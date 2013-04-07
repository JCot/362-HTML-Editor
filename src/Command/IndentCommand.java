/*
 * IndentCommand.java
 * 
 */
package Command;

import javax.swing.JTextArea;

import Editor.AutoIndent;
import GUI.EditorGUI;
import GUI.ObtainIndentDialog;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class IndentCommand implements Command{
	
	private EditorGUI gui;
	private JTextArea text;


	public IndentCommand(EditorGUI gui, JTextArea text) {
		this.gui = gui;
		this.text = text;
	}

	/**
	 * 
	 */
	@Override
	public void execute() {
		ObtainIndentDialog dialog = new ObtainIndentDialog(gui);
		String selection = text.getSelectedText();
		int position = text.getCaretPosition();
		text.cut();
		String indent = AutoIndent.indent;
		if (selection != null){
			String indented = indentSelection(selection, indent);
			text.insert(indented, position);
		} else {
			text.insert(indent, position);
		}

	}


	/*
	 * Used to indent a given selection based on the given indent.
	 */
	private String indentSelection(String selection, String indent){
		String temp = "";
		String[] lines = selection.split("\n");
		for(String line : lines){
			temp += (indent + line + "\n"); 
		}
		return temp;
	}
		

}
