package logger_015.standard;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutputStreamSpecific extends FileOutputStream {

	public FileOutputStreamSpecific(String filename) throws FileNotFoundException {
		super(filename);
	}
	
	public FileOutputStream makeOutputStream(String filename){
		FileOutputStreamSpecific foss = null;
		try {
			foss = new FileOutputStreamSpecific(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foss;
	}

}
