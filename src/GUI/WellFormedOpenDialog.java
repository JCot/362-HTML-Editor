package GUI;

/*
 * WellFormedOpenDialog.java
 */

import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JPanel;

/**
 * Dialog for the warning message associated with opening an ill formed file.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class WellFormedOpenDialog {

	/** Holds the dialog to be created */
	private JDialog dialog;
	
	/** Reference to the insert menu */
	private JMenu item;
	
	/** Reference to the EditorGUI JFrame */
	private JFrame frame;
	
	/**
	 * Constructor for a WellFormedOpenDialog, which is a dialog that warns
	 * the user that a document is not well formed as it is being opened.  It
	 * reduce functionality if the document is opened.
	 * 
	 * @param frame
	 * @param insert
	 */
	protected WellFormedOpenDialog(JFrame frame, JMenu insert){
		
		//Initialize instance variables
		this.item = insert;
		this.frame = frame;
		this.dialog = new JDialog(frame, "File Not Well Formed", 
				ModalityType.APPLICATION_MODAL);
		
		
		//Initialize dialog
		JPanel panel = new JPanel(new GridLayout(2,0)); 
		JLabel label = new JLabel("<html>The document is not well formed. " +
				"The editor will have reduced<br>functionality until " +
				"you correct the problem(s) and save.</html>");
		panel.add(label);
		
		this.item.setEnabled(false);
		
		this.dialog.add(panel);
		this.dialog.pack();
		this.dialog.setVisible(true);
		
	}
	
}
