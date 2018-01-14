package command_030_invokers;

import command_010_receiver.FileSystemReceiver;
import command_010_receiver.UnixFileSystemReceiver;
import command_010_receiver.WindowsFileSystemReceiver;

public class FileSystemReceiverUtil {
	
	public static FileSystemReceiver getUnderlyingFileSystem(){
		 String osName = System.getProperty("os.name");
		 System.out.println("Underlying OS is:"+osName);
		 if(osName.contains("Windows")){
			 return new WindowsFileSystemReceiver();
		 }else{
			 return new UnixFileSystemReceiver();
		 }
	}
	
}