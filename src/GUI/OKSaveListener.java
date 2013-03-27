/*
 * OKSaveListener.java
 * 
 * Version:
 * $Id$
 *
 * Revisions:
 * $Log$
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JDialog;

import Editor.HtmlEditor;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class OKSaveListener implements ActionListener {

	private JDialog dialog;
	private File file;
	private String save;
	
	protected OKSaveListener(JDialog dialog, File file, String save){
		this.file = file;
		this.save = save;
		this.dialog = dialog;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
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
