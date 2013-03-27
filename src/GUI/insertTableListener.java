package GUI;

/*
 * insertTableListener.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

import HTMLConstructs.HTMLConstruct;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class insertTableListener implements ActionListener {

	private HTMLConstruct tag;
	private JTabbedPane tab;
	
	public insertTableListener(HTMLConstruct tag, JTabbedPane tab){
		this.tag = tag;
		this.tab = tab;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.tab.getComponentCount() != 0){
			JDialog dialog = new ObtainTableDialog(this.tab, this.tag);
		}

	}

}
