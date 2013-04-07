package GUI;

/*
 * IndentListener.java
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.text.Utilities;

import Command.Command;
import Command.IndentCommand;

/**
 * ActionListener that handles the indentation of a selection of text.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class IndentListener implements ActionListener {

	/** Reference to the JTabbedPane*/
	private JTabbedPane tab;
	
	/** Reference to the EditorGUI */
	private EditorGUI gui;
	
	/**
	 * Constructor for an IndentListener, which handles indenting selected text.
	 * 
	 * @param gui    EditorGUI reference
	 * @param tab    JTabbedPane reference
	 */
	protected IndentListener (EditorGUI gui, JTabbedPane tab){
		this.tab = tab;
		this.gui = gui;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed
	 * (java.awt.event.ActionEvent)
	 * 
	 * Specified by ActionListener, this will display a dialog to get the
	 * desired indent and then indent the selected text.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JScrollPane scroll = (JScrollPane) this.tab.getSelectedComponent();
		if (scroll != null){
			
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			Command indent = new IndentCommand(this.gui, text);
			indent.execute();
		}
	}
}
