package reports;

public class ClassHasInvalidConstructor extends RuntimeException {
    public ClassHasInvalidConstructor(String className) {
        super("The child class" + className + " should have only one default constructor with out parameters");
    }
}
