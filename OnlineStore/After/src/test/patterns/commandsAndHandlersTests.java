package patterns;

import org.junit.Assert;
import org.junit.Test;
import patterns.crosscuttingconcerns.LogDecoratorHandler;
import patterns.sample.UserValidInformation;
import patterns.sample.ValidateUser;
import patterns.sample.ValidateUserCommandHandler;

public class commandsAndHandlersTests {

    @Test
    public void shouldCreateACommand() throws Exception{
        BasicResponse<UserValidInformation> user = new LogDecoratorHandler<ValidateUser, BasicResponse<UserValidInformation>>(
                            new ValidateUserCommandHandler(new LoginService()))
                            .Handle(new ValidateUser("uzi.mamani@mckinsey.com"));

        Assert.assertNotNull(user);  // no hacer esto en casa

    }
}
