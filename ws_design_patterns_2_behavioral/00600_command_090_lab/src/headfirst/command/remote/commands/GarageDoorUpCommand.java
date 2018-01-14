package headfirst.command.remote.commands;

import headfirst.command.remote.GarageDoor;
import headfirst.command.remote.controllers.Command;

public class GarageDoorUpCommand implements Command {
	GarageDoor garageDoor;

	public GarageDoorUpCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	public void execute() {
		garageDoor.up();
	}
}
