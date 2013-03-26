package GUI;

/*
 * CancelListener.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class CancelListener implements ActionListener {

	private JDialog dialog;
	
	public CancelListener(JDialog dialog){
		this.dialog = dialog;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dialog.dispose();
	}

}
