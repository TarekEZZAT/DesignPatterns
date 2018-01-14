public interface CommandExecutor {

	public void runCommand(String cmd) throws Exception;

	public void runCommand(String[] cmd) throws Exception;
}