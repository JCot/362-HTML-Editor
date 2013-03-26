package GUI;

/*
 * SaveListener.java
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class SaveListener implements ActionListener {

	/** */
	private JFileChooser fileChooser;
	
	/** */
	private JMenuItem menu;
	
	/**
	 * 
	 * @param fileChooser
	 * @param menu
	 */
	protected SaveListener(JFileChooser fileChooser, JMenuItem menu) {
		this.fileChooser = fileChooser;
		this.menu = menu;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int userReturn = this.fileChooser.showSaveDialog(menu);
		
		if (userReturn == JFileChooser.APPROVE_OPTION) {
			//Save here
			File file = this.fileChooser.getSelectedFile();
			System.out.println(file.getName() + " Saved");
		} else {
			System.out.println("Cancelled");
		}
	}

}
