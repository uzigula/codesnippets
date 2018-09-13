package patterns;

public interface IAmCommandHandler<TCommand extends IAmCommand<TResponse>, TResponse> {

    TResponse Handle(TCommand command) throws Exception;
}

