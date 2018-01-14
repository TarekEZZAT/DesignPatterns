package headfirst.command.remote.commands;

import headfirst.command.remote.Light;
import headfirst.command.remote.controllers.Command;

public class LivingroomLightOffCommand implements Command {
	Light light;

	public LivingroomLightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.off();
	}
}
