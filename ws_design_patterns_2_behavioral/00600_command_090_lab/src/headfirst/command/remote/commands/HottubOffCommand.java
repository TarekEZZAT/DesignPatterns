package headfirst.command.remote.commands;

import headfirst.command.remote.Hottub;
import headfirst.command.remote.controllers.Command;

public class HottubOffCommand implements Command {
	Hottub hottub;

	public HottubOffCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	public void execute() {
		hottub.cool();
		hottub.off();
	}
}
