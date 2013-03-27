package GUI;
/*
 * NewTabListener.java
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

import Editor.HtmlEditor;

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
	
	private JMenu menu;
	
	private JFrame frame;
	
	/**
	 * Constructor for a NewTabListener
	 * @param tab - JTabbedPane - Reference to the tabbed pane used in the GUI.
	 */
	protected NewTabListener(JFrame frame, JTabbedPane tab, 
			JFileChooser fileChooser, JMenu menu){
		this.tab = tab;
		this.fileChooser = fileChooser;
		this.menu = menu;
		this.frame = frame;
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
		
		if (arg0.getActionCommand().equals("New")){
			
			JScrollPane scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			this.tab.add("Untitled", scroll);
			File file = new File("Untitled");
			HtmlEditor.openFile(file);
		
		} else {
			
			int userReturn = this.fileChooser.showOpenDialog(menu);
			
			if (userReturn == JFileChooser.APPROVE_OPTION) {
				File file = this.fileChooser.getSelectedFile();
				boolean fileExists = HtmlEditor.fileExists(file);
				if (!fileExists){
					boolean check = HtmlEditor.wellFormedCheck(file);
					if (check){
						String openedFile = HtmlEditor.openFile(file);
						text.setText(openedFile);
						JScrollPane scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
								JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.tab.add(file.getName(), scroll);
					} else {
						WellFormedOpenDialog open = new WellFormedOpenDialog
								(this.frame, this.menu);
						String openedFile = HtmlEditor.openFile(file);
						text.setText(openedFile);
						JScrollPane scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
								JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.tab.add(file.getName(), scroll);
					}
				}
			} else {
				System.out.println("Cancelled");
			}
			
		}
	}

}
