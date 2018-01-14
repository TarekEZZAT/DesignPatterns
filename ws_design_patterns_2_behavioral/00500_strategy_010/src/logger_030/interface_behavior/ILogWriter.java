package logger_030.interface_behavior;

import java.io.PrintStream;

public interface ILogWriter {
    void Write(PrintStream file, String message);
}
