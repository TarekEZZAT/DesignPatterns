package headfirst.command.remote.commands;

import headfirst.command.remote.Light;
import headfirst.command.remote.controllers.Command;

public class LivingroomLightOnCommand implements Command {
	Light light;

	public LivingroomLightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.on();
	}
}
