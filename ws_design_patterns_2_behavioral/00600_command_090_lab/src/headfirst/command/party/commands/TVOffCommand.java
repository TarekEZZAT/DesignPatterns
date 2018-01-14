package headfirst.command.party.commands;

import headfirst.command.party.TV;
import headfirst.command.party.controllers.Command;

public class TVOffCommand implements Command {
	TV tv;

	public TVOffCommand(TV tv) {
		this.tv= tv;
	}

	public void execute() {
		tv.off();
	}

	public void undo() {
		tv.on();
	}
}
