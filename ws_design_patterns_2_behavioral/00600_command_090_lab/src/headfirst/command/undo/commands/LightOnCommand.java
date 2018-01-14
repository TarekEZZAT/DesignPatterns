package headfirst.command.undo.commands;

import headfirst.command.undo.Light;
import headfirst.command.undo.controllers.Command;

public class LightOnCommand implements Command {
	Light light;
	int level;
	public LightOnCommand(Light light) {
		this.light = light;
	}
 
	public void execute() {
        level = light.getLevel();
		light.on();
	}
 
	public void undo() {
		light.dim(level);
	}
}
