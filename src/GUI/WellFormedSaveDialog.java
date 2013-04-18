package GUI;

/*
 * WellFormedSaveDialog.java
 * 
 */


import java.awt.Dialog.ModalityType;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;

import Editor.HtmlEditor;


/**
 * A Dialog for warning the user that the current file being saved is not well
 * formed and prompts the user to continue.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class WellFormedSaveDialog implements ActionListener {

	/** Holds the dialog to be created */
	private JDialog dialog;
	
	/** Holds the file being saved */
	private File file;
	
	/** holds the string being saved */
	private String save;
	
	private EditorGUI frame;
	/**
	 * Constructor for the WellFormedSaveDialog.  It creates a dialog warning
	 * the user that the current document being saved is not well formed and
	 * prompts for the user to continue saving anyways.
	 * 
	 * @param frame
	 * @param file
	 * @param save
	 */
	public WellFormedSaveDialog(EditorGUI frame, File file, String save){
		//Initialize instance variables
		this.file = file;
		this.save = save;
		this.frame = frame;
		this.dialog = new JDialog(frame, "Continue with Save?", 
				ModalityType.APPLICATION_MODAL);
		
		//Initialize the dialog's display
		JPanel panel = new JPanel(new GridLayout(2,0)); 
		JLabel label = new JLabel("<html>The document is not well formed and " +
				"will reduce functionality.<br>Continue saving?</html>");
		panel.add(label);
		
		JPanel buttons = new JPanel(new GridLayout(0,2));
		JButton ok = new JButton("OK");
		ok.addActionListener(this);
		buttons.add(ok);
		
		
		JButton cancel = new JButton("Cancel");
		ActionListener cancelListener = new CancelListener(this.dialog);
		cancel.addActionListener(cancelListener);
		buttons.add(cancel);
		panel.add(buttons);
		
		//Display the dialog
		this.dialog.add(panel);
		this.dialog.pack();
		this.dialog.setVisible(true);
		
	}

	/**
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean fileExists = HtmlEditor.fileExists(this.file);
		JMenu insert = this.frame.getInsertMenu();
		if(!fileExists){
			HtmlEditor.saveAsIllFormed(this.file, this.save);
		} else {
			HtmlEditor.saveIllFormed(this.file, this.save);
		}
		insert.setEnabled(false);
		this.dialog.dispose();
		
	}
}
