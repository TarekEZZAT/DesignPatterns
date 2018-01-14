
public class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin;
	private CommandExecutor executor;

	public CommandExecutorProxy(String user, String pwd) {
		if ("peter".equals(user) && "peter".equals(pwd))
			isAdmin = true;
		executor = new CommandExecutorImpl();
	}

	@Override
	public void runCommand(String cmd) throws Exception {
		if (isAdmin) {
			executor.runCommand(cmd);
		} else {
			if (cmd.trim().toLowerCase().contains("rmdir")) {
				throw new Exception("rmdir command is not allowed for non-admin users.");
			}
			else if (cmd.trim().startsWith("rmdir")) {
				throw new Exception("rmdir command is not allowed for non-admin users.");
			} else {
				executor.runCommand(cmd);
			}
		}
	}

	@Override
	public void runCommand(String[] cmd) throws Exception {
		// TODO Auto-generated method stub
		executor.runCommand(cmd);

	}

}