package GUI;
/*
 * NewTabListener.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import Command.Command;
import Command.NewCommand;
import Command.OpenCommand;
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
		
		//If a new tab is requested
		if (arg0.getActionCommand().equals("New")){
			Command newTab = new NewCommand(this.frame, this.tab);
			newTab.execute();
			
		//If a file is being opened
		} else {
		
			int userReturn = this.fileChooser.showOpenDialog(menu);
			if (userReturn == JFileChooser.APPROVE_OPTION) {
				File file = this.fileChooser.getSelectedFile();
				boolean fileExists = HtmlEditor.fileExists(file);
				if (!fileExists){
					Command open = new OpenCommand(this.frame, file, this.menu);
					open.execute();
				}
			} else {
				System.out.println("Cancelled");
			}
			
		}
	}

	
}
