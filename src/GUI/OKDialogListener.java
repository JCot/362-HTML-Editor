package GUI;

/*
 * OKDialogListener.java
 * 
 * Version:
 * $Id$
 *
 * Revisions:
 * $Log$
 */

import java.awt.Component;
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
public class OKDialogListener implements ActionListener {

	private ObtainSizeDialog dialog;
	private JTextField entry;
	
	public OKDialogListener(ObtainSizeDialog dialog, JTextField entry) {
		this.dialog = dialog;
		this.entry = entry;
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		HTMLConstruct tag = this.dialog.getConstruct();
		JTabbedPane tab = this.dialog.getTabs();
		JScrollPane scroll = (JScrollPane) tab.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			String sizeString = this.entry.getText();
			if (sizeString.matches("\\d+")){
				int size = Integer.parseInt(sizeString);
				String insertTag = tag.insertList(size);
				int position = text.getCaretPosition();
				text.insert(insertTag, position);
				this.dialog.dispose();
			}
		}

	}

}
