package headfirst.command.simpleremote.commands;

import headfirst.command.simpleremote.Light;
import headfirst.command.simpleremote.controllers.Command;

public class LightOffCommand implements Command {
	Light light;
 
	public LightOffCommand(Light light) {
		this.light = light;
	}
 
	public void execute() {
		light.off();
	}
}
