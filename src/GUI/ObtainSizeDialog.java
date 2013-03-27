package GUI;

import java.awt.Dialog.ModalityType;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import HTMLConstructs.HTMLConstruct;

/*
 * ObtainSizeDialog.java
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
public class ObtainSizeDialog{

	private JPanel panel;
	private JTextField userNumber;
	private JTabbedPane tab;
	private HTMLConstruct construct;
	private JDialog dialog;
		
	protected ObtainSizeDialog(JFrame frame, JTabbedPane tab, HTMLConstruct construct){
		//Initialize fields and dialog frame
		this.dialog = new JDialog(frame, "Enter a size", ModalityType.APPLICATION_MODAL);
		this.tab = tab;
		this.construct = construct;
		this.dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

		//New panel to organize the dialog
		this.panel = new JPanel(new GridLayout(3,0));
		JLabel message = new JLabel();
		message.setText("Enter the number of list entries:");
		this.userNumber = new JTextField();

		//Button panel for "OK" and "Cancel" Buttons
		JPanel buttonPanel = new JPanel(new GridLayout(0,2));
		JButton ok = new JButton("Ok");
		ActionListener okListener = new OKListListener(this, this.dialog, this.userNumber);
		ok.addActionListener(okListener);
		
		JButton cancel = new JButton("Cancel");
		ActionListener cancelListener = new CancelListener(this.dialog);
		cancel.addActionListener(cancelListener);
		
		buttonPanel.add(ok);
		buttonPanel.add(cancel);


		//Combine the panels and set the display for the dialog frame
		this.panel.add(message);
		this.panel.add(this.userNumber);
		this.panel.add(buttonPanel);

		
		this.dialog.add(this.panel);
		this.dialog.pack();
		this.dialog.setVisible(true);
	}
	
	protected JDialog getDialog(){
		return this.dialog;
	}
	
	protected HTMLConstruct getConstruct(){
		return this.construct;
	}
	
	protected JTabbedPane getTabs(){
		return this.tab;
	}
	
}
