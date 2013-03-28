package GUI;

/*
 * OKIndentListener.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Editor.AutoIndent;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class OKIndentSpaceListener implements ActionListener { 

	private ObtainIndentDialog indentDialog;
	private JDialog dialog;
	private JTextField userEntry;
	private EditorGUI gui;
	
	
	
	protected OKIndentSpaceListener(ObtainIndentDialog indentDialog, JDialog dialog,
			JTextField userEntry, EditorGUI gui){
		this.dialog = dialog;
		this.indentDialog = indentDialog;
		this.userEntry = userEntry;
		this.gui = gui;
	
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#
	 * actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String sizeString = this.userEntry.getText();
		if (sizeString.matches("\\d+")){
			int spaces = Integer.parseInt(sizeString);
			this.gui.setIndent(AutoIndent.indent(spaces));
			this.dialog.dispose();
		}

	}

}
