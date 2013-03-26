package GUI;

/*
 * InsertListListener.java
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import HTMLConstructs.HTMLConstruct;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class InsertListListener implements ActionListener {

	private JTabbedPane tab;
	private HTMLConstruct tag;
	private JDialog dialog;
	
	public InsertListListener(HTMLConstruct tag, JTabbedPane tab){
		this.tab = tab;
		this.tag = tag;		
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.tab.getComponentCount());
		if ((this.tab.getComponentCount()) == 0){
			JDialog dialog = new ObtainSizeDialog(this.tab, this.tag);
		}
		
	}

}
