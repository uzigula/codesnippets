package patterns.sample;

import patterns.BasicResponse;
import patterns.IAmCommandHandler;

public class CreateUserCommandHandler implements IAmCommandHandler<CreateUser, BasicResponse<User>> {

    public BasicResponse<User> Handle(CreateUser command) throws Exception {

        //se pone la logica de negocio que corresponde a crear un usuario
        return new BasicResponse<User>(new User(command.getUserName(), command.getEmail()));

    }
}
