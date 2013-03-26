package GUI;
/*
 * NewTabListener.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
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
	
	/** Reference to the file chooser */
	private JFileChooser fileChooser;
	
	private JMenuItem menu;
	
	/**
	 * Constructor for a NewTabListener
	 * @param tab - JTabbedPane - Reference to the tabbed pane used in the GUI.
	 */
	protected NewTabListener(JTabbedPane tab, JFileChooser fileChooser, JMenuItem menu){
		this.tab = tab;
		this.fileChooser = fileChooser;
		this.menu = menu;
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
		JScrollPane scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//Add Scrolling here
		
		if (numberOfTabs == 0){
			this.tab.setVisible(true);
		}
		
		if (arg0.getActionCommand().equals("New")){
			//Possibly open here
			this.tab.add("Untitled", scroll);
		
		} else {
			
			int userReturn = this.fileChooser.showOpenDialog(menu);
			
			if (userReturn == JFileChooser.APPROVE_OPTION) {
				//Open here
				File file = this.fileChooser.getSelectedFile();
				System.out.println(file.getName() + " Opened");
			} else {
				System.out.println("Cancelled");
			}
			
		}
	}

}
