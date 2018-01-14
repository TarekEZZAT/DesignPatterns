package headfirst.command.party.commands;

import headfirst.command.party.Light;
import headfirst.command.party.controllers.Command;

public class LivingroomLightOffCommand implements Command {
	Light light;

	public LivingroomLightOffCommand(Light light) {
		this.light = light;
	}
	public void execute() {
		light.off();
	}
	public void undo() {
		light.on();
	}
}
