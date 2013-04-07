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

import Command.AutoWrapCommand;
import Command.Command;

/**
 * ActionListener for toggling the Auto-Wrap
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class WrapListener implements ActionListener {

	/** Reference to the JTabbedPane */
	private JTabbedPane tab;
	
	/** Reference to the Check Box Menu */
	private JCheckBoxMenuItem check;
	
	/**
	 * Constructor for a WrapListener.  It listens to the CheckBoxMenu and will
	 * toggle the Auto-Wrap accordingly.
	 * 
	 * @param tab
	 * @param check
	 */
	protected WrapListener(JTabbedPane tab, JCheckBoxMenuItem check){
		this.tab = tab;
		this.check = check;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#
	 * actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * Specified by ActionListener, will get the current selected text area and 
	 * enable/disable its Auto-Wrap.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Command wrap = new AutoWrapCommand(this.tab, this.check);
		wrap.execute();
		

	}

}
