package headfirst.command.party.commands;

import headfirst.command.party.Light;
import headfirst.command.party.controllers.Command;

public class LightOnCommand implements Command {
	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.on();
	}

	public void undo() {
		light.off();
	}
}
