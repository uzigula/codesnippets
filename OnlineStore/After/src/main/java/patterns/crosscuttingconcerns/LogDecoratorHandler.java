package patterns.crosscuttingconcerns;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import patterns.IAmCommand;
import patterns.IAmCommandHandler;



public class LogDecoratorHandler<TCommand extends IAmCommand<TResponse>, TResponse> implements IAmCommandHandler<TCommand, TResponse> {
    private final IAmCommandHandler<TCommand, TResponse> innerHandler;
    private Logger logger;

    public LogDecoratorHandler(IAmCommandHandler<TCommand, TResponse> innerHandler) {
        logger = LogManager.getLogger("log");  // inyectar el logger en el constructor
        this.innerHandler = innerHandler;
    }
    public TResponse Handle(TCommand command) throws Exception {
        try{
            logger.debug("Executing ", command);
            TResponse result = innerHandler.Handle(command); // todas la excepciones esperadas de logica de negocio se controlan dentro del comando
            logger.debug("Finalizo la ejecuc ejecucion de " +command.getClass().getName() , command );

            return result;
        }
        catch (SecurityException e){
            throw e;
        }
        catch (BGExpectedException e) {
            logger.info("expected exception",e);
            throw e; // esto debneria ser capturado por framework liferay, springboot u  otra cosa y que mande un http 400
        }
        catch(Exception e) {
            logger.error("Error ejecutando " + command.getClass().getName(), e);
            //return new BasicResponse(e);
            throw e;  // esto debneria ser capturado por framework liferay, springboot u  otra cosa y que mande un http 500
        }
    }
}
