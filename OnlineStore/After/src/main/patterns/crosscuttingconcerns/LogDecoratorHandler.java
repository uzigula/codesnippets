package patterns.crosscuttingconcerns;


import patterns.BasicResponse;
import patterns.IAmCommand;
import patterns.IAmCommandHandler;
import patterns.ILog;

public class LogDecoratorHandler<TCommand extends IAmCommand<TResponse>, TResponse> implements IAmCommandHandler<TCommand, TResponse> {
    private final IAmCommandHandler<TCommand, TResponse> innerHandler;
    private final ILog logger;

    public LogDecoratorHandler(IAmCommandHandler<TCommand, TResponse> innerHandler) {
        logger = LoggerManager.GetLog();  // inyectar el logger en el constructor
        this.innerHandler = innerHandler;
    }
    public TResponse Handle(TCommand command) throws Exception {
        try{
            logger.Debug("Exexuting ", command);
            TResponse result = innerHandler.Handle(command); // todas la excepciones esperadas de logica de negocio se controlan dentro del comando
            logger.Debug("Finalizo la ejecuc ejecucion de " , command);

            return result;
        }
        catch (BGExpectedException e) {
            logger.Info(e);
            throw e; // esto debneria ser capturado por framework liferay, springboot u  otra cosa y que mande un http 400
        }
        catch(Exception e) {
            logger.Error("Error ejecujanto comanddo", command, e);
            //return new BasicResponse(e);
            throw e;  // esto debneria ser capturado por framework liferay, springboot u  otra cosa y que mande un http 500
        }
    }
}
