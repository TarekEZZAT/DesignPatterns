package headfirst.command.simpleremote.controllers;

import headfirst.command.simpleremote.GarageDoor;
import headfirst.command.simpleremote.Light;
import headfirst.command.simpleremote.commands.GarageDoorOpenCommand;
import headfirst.command.simpleremote.commands.LightOnCommand;

public class RemoteControlTest {
	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light();
		GarageDoor garageDoor = new GarageDoor();
		LightOnCommand lightOn = new LightOnCommand(light);
		GarageDoorOpenCommand garageOpen = 
		    new GarageDoorOpenCommand(garageDoor);
 
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
		remote.setCommand(garageOpen);
		remote.buttonWasPressed();
    }
}
