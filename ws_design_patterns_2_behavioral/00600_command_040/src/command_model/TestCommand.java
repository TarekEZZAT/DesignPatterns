package command_model;

import command_interface.Command;

class Fan {
	public void startRotate() {
		System.out.println("Fan is rotating");
	}

	public void stopRotate() {
		System.out.println("Fan is not rotating");
	}
}

class Light {
	public void turnOn() {
		System.out.println("Light is on ");
	}

	public void turnOff() {
		System.out.println("Light is off");
	}
}

class Switch {
	private Command UpCommand, DownCommand;

	public Switch(Command Up, Command Down) {
		UpCommand = Up; // concrete Command registers itself with the invoker
		DownCommand = Down;

	}

	void flipUp() { // invoker calls back concrete Command, which executes the
					// Command on the receiver
		UpCommand.execute();
	}

	void flipDown() {
		DownCommand.execute();
	}
}

class LightOnCommand implements Command {
	private Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		this.light.turnOn();
	}
}

class LightOffCommand implements Command {
	private Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		this.light.turnOff();
	}
}

class FanOnCommand implements Command {
	private Fan fan;

	public FanOnCommand(Fan fan) {
		this.fan = fan;
	}

	public void execute() {
		this.fan.startRotate();
	}
}

class FanOffCommand implements Command {
	private Fan fan;

	public FanOffCommand(Fan fan) {
		this.fan = fan;
	}

	public void execute() {
		this.fan.stopRotate();
	}
}

public class TestCommand {
	public static void main(String[] args) {
		Light testLight = new Light();
		LightOnCommand testLOC = new LightOnCommand(testLight);
		LightOffCommand testLFC = new LightOffCommand(testLight);
		Switch testSwitch = new Switch(testLOC, testLFC);
		testSwitch.flipUp();
		testSwitch.flipDown();
		Fan testFan = new Fan();
		FanOnCommand foc = new FanOnCommand(testFan);
		FanOffCommand ffc = new FanOffCommand(testFan);
		Switch ts = new Switch(foc, ffc);
		ts.flipUp();
		ts.flipDown();
	}
}
