/*
 * UndoManager.java
 * 
 */
package Command;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class UndoManager {
	
	private static UndoManager instance;
	
	private ArrayList<LinkedList<Command>> history = 
			new ArrayList<LinkedList<Command>>();
	
	private UndoManager(){
		
	}
	
	public static UndoManager getInstance(){
		if (UndoManager.instance == null){
			UndoManager.instance = new UndoManager();
			return UndoManager.instance;
		} else {
			return UndoManager.instance;
		}
	}
	
	public void addNewBuffer(){
		LinkedList<Command> undoBuffer = new LinkedList<Command>();
		this.history.add(undoBuffer);
	}
	
	public void addCommand(int index, Command command){
		LinkedList<Command> undoBuffer = this.history.get(index);
		if (undoBuffer.size() >= 3){
			undoBuffer.remove();
			undoBuffer.add(command);
		} else {
			undoBuffer.add(command);
		}
		
	}
	
	public void processUndo(int index){
		Command command;
		try{
			command = this.history.get(index).removeLast();
			command.undo();
		} catch (NoSuchElementException e){
			//do nothing, undo selection does nothing
		}
	}
	
	
}
