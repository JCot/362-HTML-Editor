/*
 * ObtainTableDialog.java
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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import HTMLConstructs.HTMLConstruct;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class ObtainTableDialog {
	
	private JPanel panel;
	private JTextField userRows;
	private JTextField userColumns;
	private JTabbedPane tab;
	private HTMLConstruct construct;
	private JDialog dialog;
	
	protected ObtainTableDialog(EditorGUI frame, JTabbedPane tab, HTMLConstruct construct){
		
		this.dialog = new JDialog(frame, "Enter Table Dimensions", ModalityType.APPLICATION_MODAL);
		this.tab = tab;
		this.construct = construct;
		this.dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
		System.out.println(frame);
		ActionListener okListener = new OKTableListener(this, this.userRows, frame, this.userColumns);
		ok.addActionListener(okListener);
		
		JButton cancel = new JButton("Cancel");
		ActionListener cancelListener = new CancelListener(this.dialog);
		cancel.addActionListener(cancelListener);
		
		buttons.add(ok);
		buttons.add(cancel);
		
		//Combine everything into JDialog frame
		this.panel.add(buttons);
		
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
