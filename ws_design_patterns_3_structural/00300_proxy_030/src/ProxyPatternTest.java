public class ProxyPatternTest {

	public static void main(String[] args) {
		CommandExecutor executor = new CommandExecutorProxy("peter", "peter");
		try {

			String[] commands = { "cmd.exe", "/c", " md " + "c:\\abcd1" };
			Runtime.getRuntime().exec(commands);
			System.out.println("done");

			String[] cmd1 = { "cmd.exe", "/c", "md c:\\abcd2" };

			executor.runCommand("cmd /c dir c:  > d:\\tmp.txt");
			executor.runCommand("cmd /c mkdir c:\\abcd3");

			executor.runCommand(cmd1);

			executor.runCommand("cmd /c rmdir c:\\abcd2");
		} catch (Exception e) {
			System.out.println("Exception Message::" + e.getMessage());
		}

	}

}