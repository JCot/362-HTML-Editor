package GUI;
import java.awt.Dialog.ModalityType;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




/*
 * WellFormedSaveDialog.java
 * 
 * Version:
 * $Id$
 *
 * Revisions:
 * $Log$
 */

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class WellFormedSaveDialog {

	private JDialog dialog;
	private File file;
	private String save;
	
	public WellFormedSaveDialog(JFrame frame, File file, String save){
		this.file = file;
		this.save = save;
		this.dialog = new JDialog(frame, "Continue with Save?", 
				ModalityType.APPLICATION_MODAL);
		
		JPanel panel = new JPanel(new GridLayout(2,0)); 
		JLabel label = new JLabel("<html>The document is not well formed and " +
				"will reduce functionality.<br>Continue saving?</html>");
		panel.add(label);
		
		JPanel buttons = new JPanel(new GridLayout(0,2));
		JButton ok = new JButton("OK");
		ActionListener okListener = new OKSaveListener(this.dialog, this.file,
				this.save);
		ok.addActionListener(okListener);
		buttons.add(ok);
		
		
		JButton cancel = new JButton("Cancel");
		ActionListener cancelListener = new CancelListener(this.dialog);
		cancel.addActionListener(cancelListener);
		buttons.add(cancel);
		panel.add(buttons);
		
		this.dialog.add(panel);
		this.dialog.pack();
		this.dialog.setVisible(true);
		
	}
}
