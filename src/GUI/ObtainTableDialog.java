package GUI;

/*
 * ObtainTableDialog.java
 */

import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

import Command.Command;
import Command.InsertCommand;
import Editor.AutoIndent;
import HTMLConstructs.HTMLConstruct;
import HTMLConstructs.Table;

/**
 * A Dialog for obtaining the user's desired insertion of table rows and columns
 * into the buffer.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class ObtainTableDialog implements ActionListener {
	
	/** JPanel to hold the dialog's components */
	private JPanel panel;
	
	/** JTextField that holds the user's row entry */
	private JTextField userRows;
	
	/** JTextField that holds the user's col entry */
	private JTextField userColumns;
	
	/** JTabbedPane reference */
	private JTabbedPane tab;
	
	/** Stores the HTMLConstruct passed in */
	private HTMLConstruct construct;
	
	/** JDialog that will be created upon instantiation */
	private JDialog dialog;
	
	private EditorGUI gui;
	
	/**
	 * Constructor for ObtainTableDialog, which will display the dialog
	 * asking for the number of table rows/columns to insert into the buffer.
	 * 
	 * @param frame    EditorGUI reference
	 * @param tab    JTabbedPane reference
	 * @param construct    Stores the HTMLConstruct
	 */
	public ObtainTableDialog(EditorGUI frame, JTabbedPane tab, 
			HTMLConstruct construct){
		
		//Create the dialog
		this.dialog = new JDialog(frame, "Enter Table Dimensions", 
				ModalityType.APPLICATION_MODAL);
		this.tab = tab;
		this.construct = construct;
		this.dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.gui = frame;
		
		//Display for entering table dimensions
		this.panel = new JPanel(new GridLayout(5,0));
		JLabel rowMessage = new JLabel("Enter a row size:");
		JLabel colMessage = new JLabel("Enter a column size:");
		this.userRows = new JTextField();
		this.userColumns = new JTextField();
		this.panel.add(rowMessage);
		this.panel.add(userRows);
		this.panel.add(colMessage);
		this.panel.add(userColumns);
		
		//Buttons for display
		JPanel buttons = new JPanel(new GridLayout(0,2));
		JButton ok = new JButton("OK");
		ok.addActionListener(this);
		
		JButton cancel = new JButton("Cancel");
		ActionListener cancelListener = new CancelListener(this.dialog);
		cancel.addActionListener(cancelListener);
		
		buttons.add(ok);
		buttons.add(cancel);
		
		//Combine components into JDialog frame
		this.panel.add(buttons);
		
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

	/**
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JTabbedPane tab = this.tab;
		JScrollPane scroll = (JScrollPane) tab.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			String rowString = this.userRows.getText();
			String colString = this.userColumns.getText();
			
			if (rowString.matches("\\d+") && colString.matches("\\d+")){
				int row = Integer.parseInt(rowString);
				int col = Integer.parseInt(colString);
				this.construct = new Table(row, col);
				
				Command command = new InsertCommand(this.construct, this.tab);
				command.execute();
				
				this.dialog.dispose();
			}
		}

	}

}
