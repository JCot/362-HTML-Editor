package GUI;

/*
 * AutoIndentListener.java
 * 
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class AutoIndentListener implements ActionListener {

	private boolean isOn;
	private String indent;
	private EditorGUI frame;
	private JCheckBoxMenuItem menu;
	
	protected AutoIndentListener(JCheckBoxMenuItem menu, EditorGUI frame, 
			String indent, boolean isOn){
		this.frame = frame;
		this.indent = indent;
		this.isOn = isOn;
		this.menu = menu;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
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
