package GUI;

/*
 * insertTableListener.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import HTMLConstructs.HTMLConstruct;

/**
 * ActionListener for inserting a table to the current buffer.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class InsertTableListener implements ActionListener {

	/** HTML table construct */
	private HTMLConstruct tag;
	
	/** Reference to the JTabbedPane */
	private JTabbedPane tab;
	
	/** Reference to the EditorGUI */
	private EditorGUI frame;
	
	/**
	 * Constructor for an InsertTableListener, which will display a dialog to
	 * obtain the dimensions of the table and insert it.  
	 * Protected to ensure that only the GUI Package can construct one.
	 * 
	 * @param frame    EditorGUI reference
	 * @param tag    HTML table construct
	 * @param tab    JTabbedPane reference
	 */
	protected InsertTableListener(EditorGUI frame, HTMLConstruct tag,
			JTabbedPane tab){
		this.tag = tag;
		this.tab = tab;
		this.frame = frame;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed
	 * (java.awt.event.ActionEvent)
	 * 
	 * Specified by ActionListener, actionPerformed simply displays a dialog
	 * for obtaining the table dimensions and passes along necessary parameters.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.tab.getComponentCount() != 0){
			ObtainTableDialog dialog = new ObtainTableDialog(frame, this.tab,
					this.tag);
		}

	}

}
