package patterns.sample;

import patterns.BasicResponse;
import patterns.IAmCommandHandler;

public class ValidateUserCommandHandler implements IAmCommandHandler<ValidateUser, BasicResponse<UserValidInformation>> {
    private final ILoginService loginService;

    public ValidateUserCommandHandler(ILoginService loginService){
        this.loginService = loginService;
    }
    public BasicResponse<UserValidInformation> Handle(ValidateUser command) {
        /*
        aqui va la logica que debe implementarse en este caso de uso
         */

        // return new FLow(I)

        //if (command.getUserName()!= null)

        return new BasicResponse<UserValidInformation>(new UserValidInformation("s","s"));
    }
}
