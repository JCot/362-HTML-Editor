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
 * ActionListener that will confirm that the user is satisfied that the desired
 * number of spaces to indent has been entered correctly.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class OKIndentSpaceListener implements ActionListener { 

	/** Reference to the previous dialog */
	private JDialog dialog;
	
	/** JTextField that holds the user's entry */
	private JTextField userEntry;
	
	/** Reference to the EditorGUI */
	private EditorGUI gui;
	
	/**
	 * Constructor for OKIndentSpaceListener that will set the Auto-Indent.
	 * Protected to ensure that only the GUI Package can construct one.
	 *
	 * @param indentDialog    ObtainIndentDialog reference
	 * @param dialog    JDialog Reference
	 * @param userEntry    JTextField reference
	 * @param gui    EditorGUI reference
	 */
	protected OKIndentSpaceListener(ObtainIndentDialog indentDialog,
			JDialog dialog, JTextField userEntry, EditorGUI gui){
		this.dialog = dialog;
		this.userEntry = userEntry;
		this.gui = gui;
	
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#
	 * actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * Specified by ActionListener, will take the user's desired number of
	 * spaces and set the Auto-Indent.
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
