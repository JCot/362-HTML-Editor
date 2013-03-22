/*
 * EditorGUI.java
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class EditorGUI extends JFrame {

	/** Boolean value denoting user's preference for auto-wrap */
	private boolean auto_wrap = false;
	
	/** Reference to the JTabbedPane used by the GUI. */
	private JTabbedPane tab;
	
	/**
	 * Constructor for an EditorGUI object.  Creates the main GUI. 
	 */
	public EditorGUI() {
		JTabbedPane tab = new JTabbedPane();
		this.tab = tab;
		final JFileChooser fileChooser = new JFileChooser();
		
		//Menu Initialization
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu options = new JMenu("Options");
		JMenu insert = new JMenu("Insert Tag");
		
		//Menu for new file
		JMenuItem newFile = new JMenuItem("New");
		newFile.setActionCommand("New");
		ActionListener newTab = new NewTabListener(tab, fileChooser, newFile);
		newFile.addActionListener(newTab);
		newFile.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		
		JMenuItem open = new JMenuItem("Open");
		open.addActionListener(newTab);
		open.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		JMenuItem save = new JMenuItem("Save");
		
		//Check boxes for menus below?
		JMenuItem wrap = new JMenuItem("Auto-Wrap");
		JMenuItem indent = new JMenuItem("Auto-Indent");
		//TO-DO: Insert Tag Menus Here

		file.add(newFile);
		file.add(open);
		file.add(save);
		options.add(wrap);
		options.add(indent);
		//TO-DO: Add Insert Tag menu items here
		
		menuBar.add(file);
		menuBar.add(options);
		menuBar.add(insert);
		
		JTextArea text = new JTextArea();
		
		//Main frame settings
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		tab.setVisible(false);
		this.add(tab);
		this.setJMenuBar(menuBar);
		this.setSize(400,400);
				
	}
	
	/**
	 * Toggles the auto-wrap.
	 */
	public void toggleAutoWrap(){
		this.auto_wrap = !(this.auto_wrap);
		
	}
	
	
	
	/**
	 * Main method. Used to test the GUI.
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		JFrame frame = new EditorGUI();
		
	}
}
