package Command;

import java.io.File;

import javax.swing.JMenu;

import Editor.HtmlEditor;
import GUI.EditorGUI;
import GUI.WellFormedSaveDialog;

/*
 * SaveCommand.java
 * 
 */

/**
 * Command for saving the current buffer to a file.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class SaveCommand implements Command {

	private File file;
	private EditorGUI frame;
	private String saveString;
	private JMenu menu;

	public SaveCommand(File file, String saveString, EditorGUI frame){
		this.file = file;
		this.saveString = saveString;
		this.frame = frame;
		this.menu = frame.getInsertMenu();
		
		
	}
	
	/**
	 * 
	 */
	@Override
	public void execute() {
		boolean fileExists = HtmlEditor.fileExists(file);
		if (!fileExists) {
			String wellFormedSave = HtmlEditor.saveAs(file, saveString);
			if(wellFormedSave.equals("Warning: This document is not " +
					"well formed.")){
				WellFormedSaveDialog save = new WellFormedSaveDialog
						(frame, file, saveString);
				
			}
			
		} else {
			String wellFormedSave = HtmlEditor.save(file, saveString);
			if(wellFormedSave.equals("Warning: This document is not " +
					"well formed.")){
				WellFormedSaveDialog save = new WellFormedSaveDialog
						(frame, file, saveString);	
				
			} else {
				this.menu.setEnabled(true);//Enable insert functionality
			}
		}
		
	}

	/**
	 * 
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
