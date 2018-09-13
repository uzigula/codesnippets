package genericExceptions;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;



public class shouldCreateExceptions {



    @Test
    public void shouldThrowModelAException()  {
        try {
            throwException();
        }
        catch (BGLoggeableExpectedException e){
            Assert.assertThat(e.contentToJSon(), containsString("uzi"));
        }


    }

    private void throwException() throws BGLoggeableExpectedException {
        User user = new User();
        user.setName("uzi");
        user.setAge(41);

        throw new UserNotFoundException(user);
    }
}
