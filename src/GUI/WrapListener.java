package GUI;

/*
 * WrapListener.java
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class WrapListener implements ActionListener {

	private JTabbedPane tab;
	private JCheckBoxMenuItem check;
	
	protected WrapListener(JTabbedPane tab, JCheckBoxMenuItem check){
		this.tab = tab;
		this.check = check;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean state = this.check.getState();
		JScrollPane scroll = (JScrollPane) this.tab.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			text.setWrapStyleWord(true);
			text.setLineWrap(state);
		}

	}

}
