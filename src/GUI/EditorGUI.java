package GUI;
/*
 * EditorGUI.java
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import HTMLConstructs.*;

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
		
		//Menus for File
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
		ActionListener saveListener = new SaveListener(fileChooser, save);
		save.addActionListener(saveListener);
		save.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		
		
		//Check boxes for menus below?
		JMenuItem wrap = new JMenuItem("Auto-Wrap");
		JMenuItem indent = new JMenuItem("Auto-Indent");
		
		
		
		//TO-DO: Insert Tag Menus Here
		
		//Basic Tags
		JMenuItem body = new JMenuItem("Body");
		HTMLConstruct bodyTag = new Body();
		ActionListener bodyListener = new InsertListener(bodyTag, this.tab);
		body.addActionListener(bodyListener);
		
		JMenuItem html = new JMenuItem("HTML");
		HTMLConstruct htmlTag = new HTML();
		ActionListener htmlListener = new InsertListener(htmlTag, this.tab);
		html.addActionListener(htmlListener);
		
		JMenuItem div = new JMenuItem("Div");
		HTMLConstruct divTag = new Div();
		ActionListener divListener = new InsertListener(divTag, this.tab);
		div.addActionListener(divListener);
		
		JMenuItem header = new JMenuItem("Header");
		HTMLConstruct headerTag = new Header();
		ActionListener headerListener = new InsertListener(headerTag, this.tab);
		header.addActionListener(headerListener);
		
		JMenuItem paragraph = new JMenuItem("Paragraph");
		HTMLConstruct paragraphTag = new Paragraph();
		ActionListener paragraphListener = new InsertListener(paragraphTag, this.tab);
		paragraph.addActionListener(paragraphListener);
		
		JMenuItem title = new JMenuItem("Title");
		HTMLConstruct titleTag = new Title();
		ActionListener titleListener = new InsertListener(titleTag, this.tab);
		title.addActionListener(titleListener);
		
		
		//Font Menus
		JMenu font = new JMenu ("Font Tags");
		
		JMenuItem bold = new JMenuItem("Bold");
		HTMLConstruct boldTag = new Bold();
		ActionListener boldListener = new InsertListener(boldTag, this.tab);
		bold.addActionListener(boldListener);
		font.add(bold);
		
		JMenuItem italic = new JMenuItem("Italic");
		HTMLConstruct italicTag = new Italic();
		ActionListener italicListener = new InsertListener(italicTag, this.tab);
		italic.addActionListener(italicListener);
		font.add(italic);
		
		
		//List Menus
		JMenu list = new JMenu("List Tags");
		
		//Prototype
		JMenuItem bulletList = new JMenuItem("Bulleted List Tag");
		HTMLConstruct bulletTag = new BulletList();
		ActionListener bulletListener = new InsertListListener(bulletTag, this.tab);
		bulletList.addActionListener(bulletListener);
		list.add(bulletList);
		//Table
		
		
		

		
		

		//End tag menus
		file.add(newFile);
		file.add(open);
		file.add(save);
		options.add(wrap);
		options.add(indent);
		//TO-DO: Add Insert Tag menu items here
		insert.add(body);
		insert.add(div);
		insert.add(font);
		insert.add(header);
		insert.add(html);
		insert.add(list);
		insert.add(paragraph);
		insert.add(title);
		
		
		//End add tag menus
		menuBar.add(file);
		menuBar.add(options);
		menuBar.add(insert);
		
		;
		
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
