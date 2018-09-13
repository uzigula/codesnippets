package reports;


public class ClassNotImplementedException extends RuntimeException {
    public ClassNotImplementedException(String message, Exception e) {
        super(message, e);
    }
}
