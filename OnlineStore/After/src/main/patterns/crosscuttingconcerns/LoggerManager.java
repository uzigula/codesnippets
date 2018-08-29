package patterns.crosscuttingconcerns;

import patterns.ILog;

public class LoggerManager {
    public static ILog GetLog() {
        return new Logger();
    }
}
