package headfirst.command.remote.commands;

import headfirst.command.remote.CeilingFan;
import headfirst.command.remote.controllers.Command;

public class CeilingFanOnCommand implements Command {
	CeilingFan ceilingFan;

	public CeilingFanOnCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}
	public void execute() {
		ceilingFan.high();
	}
}
