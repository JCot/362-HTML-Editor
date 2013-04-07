package GUI;

/*
 * InsertListListener.java
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
 * ActionListener for inserting any HTMLConstruct that is a list into the
 * current buffer.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class InsertListListener implements ActionListener {

	/** Reference to the JTabbedPane */
	private JTabbedPane tab;
	
	/** HTMLConstruct that is a list of some form. */
	private HTMLConstruct tag;
	
	/** Reference to the EditorGUI */
	private EditorGUI parent;
	
	/**
	 * Constructor for an InsertListListener, which is responsible for displaying
	 * a dialog that will obtain the number of list entries and will
	 * insert the list into the buffer. Protected to ensure that only the
	 * GUI Package can construct one.
	 * 
	 * @param frame    EditorGUI reference
	 * @param tag    HTMLConstruct that is a list
	 * @param tab    JTabbedPane reference
	 */
	protected InsertListListener(HTMLConstruct tag, JTabbedPane tab, EditorGUI frame){
		this.tab = tab;
		this.tag = tag;
		this.parent = frame;
		
		
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed
	 * (java.awt.event.ActionEvent)
	 * 
	 * Specified by ActionListener.  Will display a dialog for obtaining the size
	 * of the list and then insert the list.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((this.tab.getComponentCount()) != 0){
			
			ObtainSizeDialog dialog = new ObtainSizeDialog(this.parent, this.tab, this.tag);
		}
		
	}

}
