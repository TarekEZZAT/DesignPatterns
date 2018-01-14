package headfirst.command.simpleremote.commands;

import headfirst.command.simpleremote.Light;
import headfirst.command.simpleremote.controllers.Command;

public class LightOnCommand implements Command {
	Light light;
  
	public LightOnCommand(Light light) {
		this.light = light;
	}
 
	public void execute() {
		light.on();
	}
}
