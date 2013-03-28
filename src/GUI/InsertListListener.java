package GUI;

/*
 * InsertListListener.java
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
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
	private EditorGUI parent;
	
	public InsertListListener(EditorGUI frame, HTMLConstruct tag, JTabbedPane tab){
		this.tab = tab;
		this.tag = tag;		
		this.parent = frame;
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((this.tab.getComponentCount()) != 0){
			ObtainSizeDialog dialog = new ObtainSizeDialog(this.parent, this.tab, this.tag);
		}
		
	}

}
