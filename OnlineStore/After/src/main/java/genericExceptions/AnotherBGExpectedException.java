package genericExceptions;

public class AnotherBGExpectedException extends  BGExpectedException{
    public AnotherBGExpectedException() {
        super("Another Exception");
    }

    public AnotherBGExpectedException(Exception innerException) {
        super("Another Exception", innerException);
    }
}
