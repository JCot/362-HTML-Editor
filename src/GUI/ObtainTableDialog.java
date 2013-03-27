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
public class ObtainTableDialog extends JDialog {
	
	private JPanel panel;
	private JTextField userRows;
	private JTextField userColumns;
	private JTabbedPane tab;
	private HTMLConstruct construct;
	
	protected ObtainTableDialog(JTabbedPane tab, HTMLConstruct construct){
		this.tab = tab;
		this.construct = construct;
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
		ActionListener okListener = new OKTableListener(this, this.userRows, this.userColumns);
		ok.addActionListener(okListener);
		
		JButton cancel = new JButton("Cancel");
		ActionListener cancelListener = new CancelListener(this);
		cancel.addActionListener(cancelListener);
		
		buttons.add(ok);
		buttons.add(cancel);
		
		//Combine everything into JDialog frame
		this.panel.add(buttons);
		
		this.add(this.panel);
		this.pack();
		this.setTitle("Enter a Number");
		
		
		
		
	}
	
	protected HTMLConstruct getConstruct(){
		return this.construct;
	}
	
	protected JTabbedPane getTabs(){
		return this.tab;
	}

}
