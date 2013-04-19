package Command;

/*
 * OpenCommand.java
 * 
 */

import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import Editor.HtmlEditor;
import GUI.EditorGUI;
import GUI.EnterListener;
import GUI.WellFormedOpenDialog;

/**
 * Command for opening a new file.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class OpenCommand implements Command {

	
	private EditorGUI frame;
	private JTabbedPane tab;
	private File file;
	private JMenu menu;

	public OpenCommand(EditorGUI frame, File file, JMenu menu) {
		this.frame = frame;
		this.tab = frame.getTab();
		this.file = file;
		this.menu = menu;
	
	}
	
	/**
	 * Takes in a file object and then opens the file so that it can be displayed
	 * in the editor.
	 * 
	 * @param file    File object
	 */
	@Override
	public void execute() {
		
		JTextArea text = new JTextArea();
		KeyListener enter = new EnterListener(this.frame, this.tab);
		text.addKeyListener(enter);
		boolean check = HtmlEditor.wellFormedCheck(this.file);
		
		if (check){
			String openedFile = HtmlEditor.openFile(this.file);
			text.setText(openedFile);
			JScrollPane scroll = new JScrollPane(text, 
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			this.tab.add(file.getName(), scroll);
			
		} else {
			
			WellFormedOpenDialog open = new WellFormedOpenDialog(this.frame);
			String openedFile = HtmlEditor.openFile(file);
			text.setText(openedFile);
			JScrollPane scroll = new JScrollPane(text, 
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			this.tab.add(file.getName(), scroll);
		}
		this.tab.setVisible(true);
	}

	/**
	 * 
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
	

}
