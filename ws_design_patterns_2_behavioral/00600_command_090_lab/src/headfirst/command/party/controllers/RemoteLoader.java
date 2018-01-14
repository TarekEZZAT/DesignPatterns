package headfirst.command.party.controllers;

import headfirst.command.party.Hottub;
import headfirst.command.party.Light;
import headfirst.command.party.Stereo;
import headfirst.command.party.TV;
import headfirst.command.party.commands.HottubOffCommand;
import headfirst.command.party.commands.HottubOnCommand;
import headfirst.command.party.commands.LightOffCommand;
import headfirst.command.party.commands.LightOnCommand;
import headfirst.command.party.commands.MacroCommand;
import headfirst.command.party.commands.StereoOffCommand;
import headfirst.command.party.commands.StereoOnCommand;
import headfirst.command.party.commands.TVOffCommand;
import headfirst.command.party.commands.TVOnCommand;

public class RemoteLoader {

	public static void main(String[] args) {

		RemoteControl remoteControl = new RemoteControl();

		Light light = new Light("Living Room");
		TV tv = new TV("Living Room");
		Stereo stereo = new Stereo("Living Room");
		Hottub hottub = new Hottub();
 
		LightOnCommand lightOn = new LightOnCommand(light);
		StereoOnCommand stereoOn = new StereoOnCommand(stereo);
		TVOnCommand tvOn = new TVOnCommand(tv);
		HottubOnCommand hottubOn = new HottubOnCommand(hottub);
		LightOffCommand lightOff = new LightOffCommand(light);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		TVOffCommand tvOff = new TVOffCommand(tv);
		HottubOffCommand hottubOff = new HottubOffCommand(hottub);

		Command[] partyOn = { lightOn, stereoOn, tvOn, hottubOn};
		Command[] partyOff = { lightOff, stereoOff, tvOff, hottubOff};
  
		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffMacro = new MacroCommand(partyOff);
 
		remoteControl.setCommand(0, partyOnMacro, partyOffMacro);
  
		System.out.println(remoteControl);
		System.out.println("--- Pushing Macro On---");
		remoteControl.onButtonWasPushed(0);
		System.out.println("--- Pushing Macro Off---");
		remoteControl.offButtonWasPushed(0);
	}
}
