package GUI;

import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
/*
 * WellFormedOpenDialog.java
 * 
 * Version:
 * $Id$
 *
 * Revisions:
 * $Log$
 */
import javax.swing.JPanel;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class WellFormedOpenDialog {

	private JDialog dialog;
	private JMenu item;
	private JFrame frame;
	
	protected WellFormedOpenDialog(JFrame frame, JMenu insert){
		this.item = insert;
		this.frame = frame;
		this.dialog = new JDialog(frame, "File Not Well Formed", 
				ModalityType.APPLICATION_MODAL);
		
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
