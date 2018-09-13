package patterns.crosscuttingconcerns;

import patterns.IAmCommand;
import patterns.IAmCommandHandler;

public class SecurityDecoratorHandler<TCommand extends IAmCommand<TResponse>, TResponse> implements IAmCommandHandler<TCommand, TResponse> {

    private final IAmCommandHandler<TCommand, TResponse> innerHandler;

    public SecurityDecoratorHandler(IAmCommandHandler<TCommand, TResponse> innerHandler){
        this.innerHandler = innerHandler;
    }
    public TResponse Handle(TCommand command) throws Exception {
        //logica de seguridad
        if (IsSecure(command))
            return innerHandler.Handle(command);
        throw new SecurityException("no autorizado");
    }

    private boolean IsSecure(TCommand command) {
        return true;
    }
}
