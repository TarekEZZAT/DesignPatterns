package headfirst.command.remote.commands;

import headfirst.command.remote.Light;
import headfirst.command.remote.controllers.Command;

public class LightOnCommand implements Command {
	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.on();
	}
}
