package Command;

/*
 * NewCommand.java
 * 
 */

import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import Editor.HtmlEditor;
import GUI.EditorGUI;
import GUI.EnterListener;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class NewCommand implements Command{

	/** Reference to the EditorGUI */
	private EditorGUI frame;
	
	/** Reference to the JTabbedPane being used. */
	private JTabbedPane tab;
	
	/**
	 * Constructor for a NewCommand. Represents the command for when the "New"
	 * menu item is selected.
	 * 
	 * @param frame    EditorGUI reference
	 * @param tab    JTabbedPane reference used by the editor
	 */
	public NewCommand(EditorGUI frame, JTabbedPane tab) {
		this.frame = frame;
		this.tab = tab;
	}
	
	/**
	 * Opens a new tab with a blank JTextArea.
	 */
	@Override
	public void execute() {
		JTextArea text = new JTextArea();
		KeyListener enter = new EnterListener(this.frame, this.tab);
		text.addKeyListener(enter);
		JScrollPane scroll = new JScrollPane(text, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.tab.add("Untitled", scroll);
		UndoManager manager = UndoManager.getInstance();
		manager.addNewBuffer();
		File file = new File("Untitled");
		HtmlEditor.openFile(file);
	}

	/**
	 * 
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
