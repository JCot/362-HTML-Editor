package GUI;

/*
 * ObtainSizeDialog.java
 * 
 */

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

/**
 * A dialog for obtaining the user's desired amount of list entries to insert
 * into the buffer.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class ObtainSizeDialog{

	/** JPanel to hold the dialog's components */
	private JPanel panel;
	
	/** JTextField that holds the user's entry */
	private JTextField userNumber;
	
	/** JTabbedPane reference */
	private JTabbedPane tab;
	
	/** Stores the HTMLConstruct passed in */
	private HTMLConstruct construct;
	
	/** JDialog that will be created upon instantiation */
	private JDialog dialog;
		
	/**
	 * Constructor for ObtainSizeDialog, which will display the dialog
	 * asking for the number of list entries to insert into the buffer.
	 * Protected to ensure that only the GUI Package can construct one.
	 * 
	 * @param frame    EditorGUI reference
	 * @param tab    JTabbedPane reference
	 * @param construct    Stores the HTMLConstruct
	 */
	protected ObtainSizeDialog(EditorGUI frame, JTabbedPane tab, 
			HTMLConstruct construct){
		
		//Initialize fields and dialog frame
		this.dialog = new JDialog(frame, "Enter a size",
				ModalityType.APPLICATION_MODAL);
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
		ActionListener okListener = new OKListSizeListener(this, this.dialog, 
				this.userNumber, frame);
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
	
	/**
	 * Gets the dialog.
	 * @return dialog    JDialog instance
	 */
	protected JDialog getDialog(){
		return this.dialog;
	}
	
	/**
	 * Gets the HTMLConstruct
	 * @return construct    HTMLConstruct being stored
	 */
	protected HTMLConstruct getConstruct(){
		return this.construct;
	}
	
	/**
	 * Gets the JTabbedPane.
	 * @return tab    JTabbedPane used in the GUI
	 */
	protected JTabbedPane getTabs(){
		return this.tab;
	}
	
}
