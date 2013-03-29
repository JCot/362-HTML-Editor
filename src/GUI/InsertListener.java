package GUI;

/*
 * InsertListener.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import HTMLConstructs.HTMLConstruct;

/**
 * ActionListener for inserting a basic HTMLConstruct into the buffer.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class InsertListener implements ActionListener {
	
	/** HTML construct to insert */
	private HTMLConstruct tag;
	
	/** Reference to the JTabbedPane */
	private JTabbedPane tab;
	
	/**
	 * Constructor for an InsertListener, which inserts an HTML construct.
	 * Protected to ensure that only the GUI Package can construct one.
	 * 
	 * @param tag    HTMLConstruct represents a tag
	 * @param tab    JTabbedPane reference
	 */
	protected InsertListener(HTMLConstruct tag, JTabbedPane tab) {
		this.tag = tag;
		this.tab = tab;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed
	 * (java.awt.event.ActionEvent)
	 * 
	 * Specified by ActionListener, actionPerformed uses the JTabbedPane to
	 * obtain the current tab and then inserts the HTML tag at the current
	 * position.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JScrollPane scroll = (JScrollPane) this.tab.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			String insertTag = this.tag.insert();
			int position = text.getCaretPosition();
			text.insert(insertTag, position);
		}

	}

}
