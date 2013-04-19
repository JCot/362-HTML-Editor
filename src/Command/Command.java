/*
 * Command.java
 * 
 * Version:
 * $Id$
 *
 * Revisions:
 * $Log$
 */
package Command;

/**
 * Command Interface from which Concrete Commands inherit from.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public interface Command {
	
	public void execute();
	
	public void undo();

}
