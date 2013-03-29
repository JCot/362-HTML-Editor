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
	
	/*
	 * Used to indent a given selection based on the given indent.
	 */
	private String indentSelection(String selection, String indent){
		String temp = "";
		String[] lines = selection.split("/n");
		for(String line : lines){
			temp += (indent + line + "\n"); 
		}
		return temp;
	}

}
