package GUI;

/*
 * AutoIndentListener.java
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;

/**
 * ActionListener which listens for a change in the Check Box menu for
 * Auto-Indent.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class AutoIndentListener implements ActionListener {

	/** EditorGUI reference to pass along to the dialog */
	private EditorGUI frame;
	
	/** Auto-Indent menu reference to get its current state */
	private JCheckBoxMenuItem menu;
	
	/**
	 * Constructor for AutoIndentListener.  Protected to ensure that only the
	 * GUI Package can construct one.
	 * 
	 * @param menu    JCheckBoxMenuItem for Auto-Indent
	 * @param frame    EditorGUI reference
	 */
	protected AutoIndentListener(JCheckBoxMenuItem menu, EditorGUI frame){
		this.frame = frame;
		this.menu = menu;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed
	 * (java.awt.event.ActionEvent)
	 * 
	 * actionPeformed specified by ActionListener.  It updates the state of the
	 * Auto-Indent and brings up a dialog.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean state = this.menu.getState();
		this.frame.setAutoIndent(state);
		if(state){
			ObtainIndentDialog dialog = new ObtainIndentDialog(this.frame);
		}

	}

}
