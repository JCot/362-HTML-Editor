/*
 * InsertListCommand.java
 * 
 */
package Command;

import javax.swing.JTabbedPane;

import GUI.EditorGUI;
import GUI.ObtainSizeDialog;
import HTMLConstructs.HTMLConstruct;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class InsertListCommand implements Command{
	
	private HTMLConstruct tag;
	private JTabbedPane tab;
	private EditorGUI frame;

	public InsertListCommand(HTMLConstruct tag, JTabbedPane tab, EditorGUI frame){
		this.tag = tag;
		this.tab = tab;
		this.frame = frame;
	}

	public void execute(){
		if ((this.tab.getComponentCount()) != 0){
			ObtainSizeDialog dialog = new ObtainSizeDialog(this.frame, this.tab,
					this.tag);
		}
	}
}
