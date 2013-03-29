package GUI;

/*
 * OKSaveListener.java
 * 
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JDialog;

import Editor.HtmlEditor;

/**
 * ActionListener for saving an Ill formed document.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class OKSaveListener implements ActionListener {

	/** Reference to the previous dialog */
	private JDialog dialog;
	
	/** Reference to the file being saved */
	private File file;
	
	/** Reference to the string to save */
	private String save;
	
	/**
	 * Constructor for OKSaveListener, which will save an ill formed document.
	 * 
	 * @param dialog
	 * @param file
	 * @param save
	 */
	protected OKSaveListener(JDialog dialog, File file, String save){
		this.file = file;
		this.save = save;
		this.dialog = dialog;
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed
	 * (java.awt.event.ActionEvent)
	 * 
	 * Specified by ActionListener, will save an ill formed document.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean fileExists = HtmlEditor.fileExists(this.file);
		if(!fileExists){
			HtmlEditor.saveAsIllFormed(this.file, this.save);
		} else {
			HtmlEditor.saveIllFormed(this.file, this.save);
		}
		this.dialog.dispose();

	}

}
