/*
 * OKTableListener.java
 * 
 * Version:
 * $Id$
 *
 * Revisions:
 * $Log$
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

import HTMLConstructs.HTMLConstruct;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class OKTableListener implements ActionListener {

	private ObtainTableDialog tableDialog;
	private JTextField enteredRows;
	private JTextField enteredCols;
	private JDialog dialog;
	
	public OKTableListener(ObtainTableDialog tableDialog, JTextField rows, JTextField cols) {
		this.dialog = tableDialog.getDialog();
		this.enteredRows = rows;
		this.enteredCols = cols;
		this.tableDialog = tableDialog;
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		HTMLConstruct tag = this.tableDialog.getConstruct();
		JTabbedPane tab = this.tableDialog.getTabs();
		JScrollPane scroll = (JScrollPane) tab.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			String rowString = this.enteredRows.getText();
			String colString = this.enteredCols.getText();
			if (rowString.matches("\\d+") && colString.matches("\\d+")){
				int row = Integer.parseInt(rowString);
				int col = Integer.parseInt(colString);
				String insertTag = tag.insertTable(row, col);
				int position = text.getCaretPosition();
				text.insert(insertTag, position);
				this.dialog.dispose();
			}
		}

	}

}
