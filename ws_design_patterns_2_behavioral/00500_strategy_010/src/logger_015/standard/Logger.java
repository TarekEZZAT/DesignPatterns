package logger_015.standard;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Logger {

    // declarations

    private FileOutputStream[] files = { 
			makeFileOutputStream("G:\\Users\\TarekEZZAT\\Documents\\logs\\logger0.log"),
			makeFileOutputStream("G:\\Users\\TarekEZZAT\\Documents\\logs\\logger1.log"),
			makeFileOutputStream("G:\\Users\\TarekEZZAT\\Documents\\logs\\logger2.log"), 
			};

    private PrintStream[] pss = { 
			new PrintStream(files[0]), 
			new PrintStream(files[1]), 
			new PrintStream(files[2]),
	};

    private String[] messages = { 
			new String("Write error message to log file 0"),
			new String("Write error message to log file 1 + user"),
			new String("Write error message to log file 2 + user+ email"), 
			};

 

	

	private FileOutputStream makeFileOutputStream(String string) {
		// TODO Auto-generated method stub
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(string);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fos;
	}

	
	public void LogMessage(int level) {

		WriteLogMessage(this.getPss(), level);

	}

	
	public void CloseFile(PrintStream[] files, int level){
		// TODO Auto-generated method stub
		this.getPss()[level].close();

	}

	private void WriteLogMessage(PrintStream[] files, int level) {

		this.getPss()[level].println(messages[level]);
		this.getPss()[level].flush();
	}

	// Getters and Setters
	public FileOutputStream[] getFiles() {
		return files;
	}

	public void setFiles(FileOutputStream[] files) {
		this.files = files;
	}

	public PrintStream[] getPss() {
		return pss;
	}

	public void setPss(PrintStream[] pss) {
		this.pss = pss;
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

}