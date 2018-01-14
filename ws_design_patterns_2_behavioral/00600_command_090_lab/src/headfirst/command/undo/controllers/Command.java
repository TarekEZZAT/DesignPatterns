package headfirst.command.undo.controllers;

public interface Command {
	public void execute();
	public void undo();
}
