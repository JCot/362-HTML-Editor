package GUI;

/*
 * InsertListener.java
 * 
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import HTMLConstructs.HTMLConstruct;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class InsertListener implements ActionListener {
	
	private HTMLConstruct tag;
	private JTabbedPane tab;
	
	protected InsertListener(HTMLConstruct tag, JTabbedPane tab) {
		this.tag = tag;
		this.tab = tab;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
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
