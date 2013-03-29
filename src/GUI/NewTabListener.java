package GUI;
/*
 * NewTabListener.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import Editor.HtmlEditor;

/**
 * An ActionListener that will create new tabs in the JTabbedPane that will
 * act aas buffers for both new files and existing files.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class NewTabListener implements ActionListener {

	/** Reference to the JTabbedPane being used. */
	private JTabbedPane tab;
	
	/** Reference to the file chooser */
	private JFileChooser fileChooser;
	
	/** Reference to the insert menu. Used to disable its functionality if 
	 * needed.
	 */
	private JMenu menu;
	
	/** Reference to the EditorGUI */
	private EditorGUI frame;
	
	/**
	 * Constructor for a NewTabListener. Creates new tabs and can differentiate
	 * between new files and existing ones. Protected to ensure that only the
	 * GUI Package can construct one.
	 * 
	 * @param frame    EditorGUI reference
	 * @param tab    JTabbedPane reference 
	 * @param fileChooser    JFileChooser reference
	 * @param menu    Insert menu reference
	 */
	protected NewTabListener(EditorGUI frame, JTabbedPane tab, 
			JFileChooser fileChooser, JMenu menu){
		this.tab = tab;
		this.fileChooser = fileChooser;
		this.menu = menu;
		this.frame = frame;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#
	 * actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * Adds a new tab based on the filename that is specified by 
	 * the ActionCommand.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int numberOfTabs = this.tab.getTabCount();
				
		if (numberOfTabs == 0){
			this.tab.setVisible(true);
		}
		
		if (arg0.getActionCommand().equals("New")){
			JTextArea text = new JTextArea();
			KeyListener enter = new EnterListener(this.frame, this.tab);
			text.addKeyListener(enter);
			JScrollPane scroll = new JScrollPane(text, 
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
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
					displayOpenedFile(file);
				}
			} else {
				System.out.println("Cancelled");
			}
			
		}
	}

	/**
	 * Takes in a file object and then opens the file so that it can be displayed
	 * in the editor.
	 * 
	 * @param file    File object
	 */
	public void displayOpenedFile(File file){
		JTextArea text = new JTextArea();
		KeyListener enter = new EnterListener(this.frame, this.tab);
		text.addKeyListener(enter);
		boolean check = HtmlEditor.wellFormedCheck(file);
		
		if (check){
			String openedFile = HtmlEditor.openFile(file);
			text.setText(openedFile);
			JScrollPane scroll = new JScrollPane(text, 
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			this.tab.add(file.getName(), scroll);
			
		} else {
			
			WellFormedOpenDialog open = new WellFormedOpenDialog
					(this.frame, this.menu);
			String openedFile = HtmlEditor.openFile(file);
			text.setText(openedFile);
			JScrollPane scroll = new JScrollPane(text, 
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			this.tab.add(file.getName(), scroll);
		}
		this.tab.setVisible(true);
	}
}
