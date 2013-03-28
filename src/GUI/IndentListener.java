/*
 * IndentListener.java
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

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.text.Utilities;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class IndentListener implements ActionListener {

	private JTabbedPane tab;
	private EditorGUI gui;
	
	public IndentListener (EditorGUI gui, JTabbedPane tab){
		this.tab = tab;
		this.gui = gui;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JScrollPane scroll = (JScrollPane) this.tab.getSelectedComponent();
		if (scroll != null){
			ObtainIndentDialog dialog = new ObtainIndentDialog(gui);
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			String selection = text.getSelectedText();
			int position = text.getCaretPosition();
			text.cut();
			String indent = this.gui.getIndent();
			if (selection != null){
				String indented = indentSelection(selection, indent);
				text.insert(indented, position);
			} else {
				text.insert(indent, position);
			}

		}
	}
	
	private String indentSelection(String selection, String indent){
		String temp = "";
		String[] lines = selection.split(System.getProperty("line.separator"));
		for(String line : lines){
			temp += (indent + line + "\n"); 
		}
		return temp;
	}

}
