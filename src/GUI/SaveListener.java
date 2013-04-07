package GUI;

/*
 * SaveListener.java
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import Editor.HtmlEditor;

/**
 * ActionListener for the save menu item, and when selected will prompt the user
 * to save the current file in the buffer.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class SaveListener implements ActionListener {

	/** Reference to the file chooser*/
	private JFileChooser fileChooser;
	
	
	/** Reference to the menu */
	private JMenu menu;
	
	/** Reference to the JFrame from EditorGUI */
	private JFrame frame;
	
	/** Reference to the JTabbedPane */
	private JTabbedPane tab;
	
	/**
	 * Constructor for a SaveListener.  Will take the current tab and prompt the
	 * user to save the current tab using the file chooser.
	 * 
	 * @param frame
	 * @param fileChooser
	 * @param menu
	 * @param tab
	 */
	protected SaveListener(JFrame frame, JFileChooser fileChooser, JMenu menu, 
			JTabbedPane tab) {
		this.frame = frame;
		this.fileChooser = fileChooser;
		this.menu = menu;
		this.tab = tab;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
	 * ActionEvent)
	 * 
	 * Specified by ActionListener, will take the current tab and prompt to save
	 * the file associated with said tab.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JScrollPane scroll = (JScrollPane) this.tab.getSelectedComponent();
		int currentIndex = this.tab.getSelectedIndex();
		
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			String saveString = text.getText();
			int userReturn = this.fileChooser.showSaveDialog(menu);
			
			if (userReturn == JFileChooser.APPROVE_OPTION) {
				File file = this.fileChooser.getSelectedFile();
				boolean fileExists = HtmlEditor.fileExists(file);
				if (!fileExists) {
					String wellFormedSave = HtmlEditor.saveAs(file, saveString);
					if(wellFormedSave.equals("Warning: This document is not " +
							"well formed.")){
						WellFormedSaveDialog save = new WellFormedSaveDialog
								(frame, file, saveString);
						this.menu.setEnabled(false);
					}
					
				} else {
					String wellFormedSave = HtmlEditor.save(file, saveString);
					if(wellFormedSave.equals("Warning: This document is not " +
							"well formed.")){
						WellFormedSaveDialog save = new WellFormedSaveDialog
								(frame, file, saveString);	
						this.menu.setEnabled(false);
					} else {
						this.menu.setEnabled(true);//Enable insert functionality
					}
				}
				
				this.tab.setTitleAt(currentIndex, file.getName());
				
			} else {
				System.out.println("Cancelled");
			}
		}
	}

}
