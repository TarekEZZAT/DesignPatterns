package headfirst.command.remote.commands;

import headfirst.command.remote.Stereo;
import headfirst.command.remote.controllers.Command;

public class StereoOffCommand implements Command {
	Stereo stereo;
 
	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}
 
	public void execute() {
		stereo.off();
	}
}
