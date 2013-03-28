/*
 * CloseSaveDialog.java
 * 
 * Version:
 * $Id$
 *
 * Revisions:
 * $Log$
 */
package GUI;

import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class CloseSaveDialog {
	private JDialog dialog;
	private JTabbedPane tab;

	
	protected CloseSaveDialog(EditorGUI gui, JTabbedPane tab, 
			ActionListener listener){
		this.tab = tab;
		this.dialog = new JDialog(gui, "Continue with Save?", 
				ModalityType.APPLICATION_MODAL);
		
		JPanel panel = new JPanel(new GridLayout(2,0)); 
		JLabel label = new JLabel("<html>You are about to close the editor." +
				"<br>Save all tabs?</html>");
		panel.add(label);
		
		JPanel buttons = new JPanel(new GridLayout(0,2));
		JButton ok = new JButton("OK");
		//ActionListener okListener = new SaveListener(this.dialog, this.file,
			//	this.save);
		//ok.addActionListener(okListener);
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
