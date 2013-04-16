/*
 * AutoIndentCommand.java
 * 
 */
package Command;

import javax.swing.JCheckBoxMenuItem;

import Editor.AutoIndent;
import GUI.EditorGUI;
import GUI.ObtainIndentDialog;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class AutoIndentCommand implements Command{

	/** EditorGUI reference to pass along to the dialog */
	private EditorGUI frame;
	
	/** Auto-Indent menu reference to get its current state */
	private JCheckBoxMenuItem menu;
	
	public AutoIndentCommand(JCheckBoxMenuItem menu, EditorGUI frame){
		this.frame = frame;
		this.menu = menu;
	}
	
	/**
	 * 
	 */
	@Override
	public void execute() {
		boolean state = this.menu.getState();
		AutoIndent.isOn = state;
		if(state){
			ObtainIndentDialog dialog = new ObtainIndentDialog(this.frame);
		}
		
	}
	
	public void undo() {}

	
}
