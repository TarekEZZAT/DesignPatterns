package headfirst.command.simpleremote.commands;

import headfirst.command.simpleremote.GarageDoor;
import headfirst.command.simpleremote.controllers.Command;

public class GarageDoorOpenCommand implements Command {
	GarageDoor garageDoor;

	public GarageDoorOpenCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	public void execute() {
		garageDoor.up();
	}
}
