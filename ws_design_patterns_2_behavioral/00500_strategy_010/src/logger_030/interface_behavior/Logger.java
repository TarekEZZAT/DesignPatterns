package logger_030.interface_behavior;

import java.io.PrintStream;

public class Logger {
	/* solution 1
	public ILogWriter logWriter;
	*/
	
	// solution 2
	private ILogWriter logWriter;
	public void setLogWriter(ILogWriter writer) {
		this.logWriter = writer;
	}
	// end solution 2
	
	private void WriteLogMessage(PrintStream[] files, String message) {
		for (int i = 0; i < files.length; i++) {
			logWriter.Write(files[i], message);
		}
	}
}