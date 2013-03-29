package GUI;

/*
 * CancelListener.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

/**
 * ActionListener for any cancel button that is a part of a JDialog.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class CancelListener implements ActionListener {

	/**JDialog reference to dispose in actionPerform. */
	private JDialog dialog;
	
	/**
	 * Constructor for a CancelListener.  Protected to ensure that only th GUI
	 * package can instantiated one.
	 *  
	 * @param dialog    JDialog to dispose
	 */
	protected CancelListener(JDialog dialog){
		this.dialog = dialog;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed
	 * (java.awt.event.ActionEvent)
	 * 
	 * actionPerformed as specified by ActionListener.  Disposes the JDialog
	 * that is held.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dialog.dispose();
	}

}
