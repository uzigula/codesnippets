package genericExceptions;

public class UserNotFoundException extends BGLoggeableExpectedException {

    public UserNotFoundException( Exception innerException, Object content) {
        super("User not found", innerException, content);
    }

    public UserNotFoundException(Object content) {
        super("User not found", content);
    }
}
