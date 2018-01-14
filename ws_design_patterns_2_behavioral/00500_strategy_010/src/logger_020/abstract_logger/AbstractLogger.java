package logger_020.abstract_logger;

import java.io.PrintStream;

public abstract class AbstractLogger {

    public void LogMessage(String message) {/*…*/}

    private void WriteLogMessage(PrintStream[] pss, String message) {
        for (int i=0; i < pss.length; i++)  {
        	WriteLogMessageImpl( pss[i], message);
        }
    }    

  protected abstract void WriteLogMessageImpl(PrintStream file, String msg);

}
