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
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class SaveListener implements ActionListener {

	/** */
	private JFileChooser fileChooser;
	
	
	/** */
	private JMenu menu;
	private JFrame frame;
	private JTabbedPane tab;
	
	/**
	 * 
	 * @param fileChooser
	 * @param menu
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
				System.out.println(file.getName() + " Saved");
			} else {
				System.out.println("Cancelled");
			}
		}
	}

}
