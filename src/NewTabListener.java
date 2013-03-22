/*
 * NewTabListener.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class NewTabListener implements ActionListener {

	/** Reference to the JTabbedPane being used. */
	private JTabbedPane tab;
	
	/** Name of the tab */
	private String filename;
	
	/**
	 * Constructor for a NewTabListener
	 * @param tab - JTabbedPane - Reference to the tabbed pane used in the GUI.
	 */
	public NewTabListener(JTabbedPane tab, String filename){
		this.tab = tab;
		this.filename = filename;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * Adds a new tab based on the filename that is specified in the constructor
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int numberOfTabs = this.tab.getTabCount();
		JTextArea text = new JTextArea();
		if (numberOfTabs == 0){
			this.tab.setVisible(true);
		}
		
		this.tab.add(this.filename, text);
		

	}

}
