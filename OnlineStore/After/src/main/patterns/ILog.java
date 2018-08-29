package patterns;

import patterns.crosscuttingconcerns.BGExpectedException;

public interface ILog {
    void Debug(String exexuting_, Object command);

    void Info(Exception e);

    void Error(String message, Object command, Exception e);
}
