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
 * ActionListener for getting the size of a list being inserted by the user.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class OKListSizeListener implements ActionListener {

	/** Reference to the previous dialog */
	private JDialog dialog;
	
	/** JTextField that holds the user's entry */
	private JTextField entry;
	
	/** Reference to the ObtainSizeDialog */
	private ObtainSizeDialog sizeDialog;
	
	/** Reference to the EditorGUI */
	private EditorGUI gui;
	
	/**
	 * Constructor for OKListSizeListener, which will verify the list size 
	 * entered by the user.
	 * 
	 * @param sizeDialog
	 * @param dialog
	 * @param entry
	 * @param gui
	 */
	public OKListSizeListener(ObtainSizeDialog sizeDialog, JDialog dialog,
			JTextField entry, EditorGUI gui) {
		this.dialog = dialog;
		this.entry = entry;
		this.sizeDialog = sizeDialog;
		this.gui = gui;
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed
	 * (java.awt.event.ActionEvent)
	 * 
	 * Specified by ActionListener, will get the number of list entries and
	 * insert the list into the buffer.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		HTMLConstruct tag = this.sizeDialog.getConstruct();
		JTabbedPane tab = this.sizeDialog.getTabs();
		JScrollPane scroll = (JScrollPane) tab.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			String sizeString = this.entry.getText();
			if (sizeString.matches("\\d+")){
				int size = Integer.parseInt(sizeString);
				String insertTag = tag.insertList(size);
				int position = text.getCaretPosition();
				if(this.gui.getAutoIndent()){
					String temp = "";
					String indent = this.gui.getIndent();
					String[] lines = insertTag.split("/n");
					for(String line : lines){
						if (matchListEntry(line)) {
							temp += (indent + line + "\n");
						} else if (matchListEntryDef(line)){
							temp += (indent + indent + line + "\n");
						} else {
							temp += line + "\n";
						}
					}
					insertTag = temp;
				}
				text.insert(insertTag, position);
				this.dialog.dispose();
			}
		}
	}
	
	/*
	 * Matches a line with a list entry tag
	 */
	private boolean matchListEntry(String line){
		if (line.startsWith("<li>") || line.startsWith("</li>") || 
				line.startsWith("<dt>") || line.startsWith("</dt>")){
			return true;
		}
		return false;
	}

	/*
	 * Matches a line with the list def tag
	 */
	private boolean matchListEntryDef(String line) {
		if (line.startsWith("<dd>") || line.startsWith("</dd>")){
			return true;
		}
		return false;
	}

}
