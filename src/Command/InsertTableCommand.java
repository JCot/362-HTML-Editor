/*
 * InsertTableCommand.java
 * 
 */
package Command;

import javax.swing.JTabbedPane;

import GUI.EditorGUI;
import GUI.ObtainTableDialog;
import HTMLConstructs.HTMLConstruct;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class InsertTableCommand implements Command {

	private EditorGUI frame;
	private HTMLConstruct tag;
	private JTabbedPane tab;

	public InsertTableCommand( HTMLConstruct tag, JTabbedPane tab,
			EditorGUI frame){
		this.frame = frame;
		this.tag = tag;
		this.tab = tab;
	}

	/**
	 * 
	 */
	@Override
	public void execute() {
		if(this.tab.getComponentCount() != 0){
			ObtainTableDialog dialog = new ObtainTableDialog(frame, this.tab,
					this.tag);
		}
		
	}
	
}
