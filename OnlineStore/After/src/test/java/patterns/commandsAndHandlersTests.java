package patterns;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.test.util.*;

import patterns.BasicResponse;
import patterns.IAmCommandHandler;
import patterns.LoginService;
import patterns.crosscuttingconcerns.BGExpectedException;
import patterns.crosscuttingconcerns.LogDecoratorHandler;
import patterns.crosscuttingconcerns.SecurityDecoratorHandler;
import patterns.sample.*;

import static org.mockito.Mockito.*;

public class commandsAndHandlersTests {


    @Rule
    public ExpectedException castException = ExpectedException.none();

    @Test
    public void shouldCreateACommand() throws Exception{
        BasicResponse<UserValidInformation> user =
                        new LogDecoratorHandler<ValidateUser, BasicResponse<UserValidInformation>>(
                            new ValidateUserCommandHandler(new LoginService()))
                            .Handle(new ValidateUser("uzi.mamani@mckinsey.com"));

        Assert.assertNotNull(user);  // no hacer esto en casa

    }

    @Test
    public void shouldCreateAUser() throws Exception{
        BasicResponse<User> user =
                                new LogDecoratorHandler<CreateUser,BasicResponse<User>>
                                        (
                                            new SecurityDecoratorHandler<CreateUser, BasicResponse<User>>(
                                                new CreateUserCommandHandler()
                                            )
                                        )
                                    .Handle(
                                            new CreateUser("Uzi Mamani", "uzi_mamani@mckinsey.com")
                                    );


        Assert.assertNotNull(user);


    }


    @Test
    public void shouldLogProperly() throws Exception{
        IAmCommandHandler<FooCommand, FooResponse> innerHandler = mock(IAmCommandHandler.class); // crea un test double
        when(innerHandler.Handle(any(FooCommand.class))).thenReturn(new FooResponse());  // le digo como comportarse

        Logger logger = mock(Logger.class);

        LogDecoratorHandler<FooCommand, FooResponse> sut = new LogDecoratorHandler<FooCommand, FooResponse>(innerHandler);

        ReflectionTestUtils.setField(sut,"logger", logger);

        sut.Handle(new FooCommand());
        verify(logger, times(2)).debug(any(String.class),any(Object.class));

    }

    @Test
    public void shouldLogAnException() throws Exception {

            //castException.expect(BGExpectedException.class);

            IAmCommandHandler<FooCommand, FooResponse> innerHandler = mock(IAmCommandHandler.class); // crea un test double
            when(innerHandler.Handle(any(FooCommand.class))).thenThrow(new BGExpectedException()); // le digo como comportarse

            Logger logger = mock(Logger.class);

            doNothing().when(logger).debug(any(String.class), any(Object.class));
            doNothing().when(logger).info(any(String.class), any(BGExpectedException.class));

            LogDecoratorHandler<FooCommand, FooResponse> sut = new LogDecoratorHandler<FooCommand, FooResponse>(innerHandler);

            ReflectionTestUtils.setField(sut, "logger", logger);

            try {sut.Handle(new FooCommand());}
            catch (Exception ex) {
                //
            }
            finally {
                verify(logger, times(1)).debug(any(String.class), any(Object.class));
                verify(logger, times(1)).info(any(String.class), any(BGExpectedException.class));
            }
    }
    @Test
    public void shouldLogAnUnhandledException() throws Exception {

        //castException.expect(BGExpectedException.class);

        IAmCommandHandler<FooCommand, FooResponse> innerHandler = mock(IAmCommandHandler.class); // crea un test double
        when(innerHandler.Handle(any(FooCommand.class))).thenThrow(new InstantiationException()); // le digo como comportarse

        Logger logger = mock(Logger.class);

        doNothing().when(logger).debug(any(String.class), any(Object.class));
        doNothing().when(logger).error(any(String.class), any(BGExpectedException.class));

        LogDecoratorHandler<FooCommand, FooResponse> sut = new LogDecoratorHandler<FooCommand, FooResponse>(innerHandler);

        ReflectionTestUtils.setField(sut, "logger", logger);

        try {sut.Handle(new FooCommand());}
        catch (Exception ex) {
            //
        }
        finally {
            verify(logger, times(1)).debug(any(String.class), any(Object.class));
            verify(logger, times(1)).info(any(String.class), any(BGExpectedException.class));
        }
    }


}
