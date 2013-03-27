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
		ActionListener newTab = new NewTabListener(this, tab, fileChooser, insert);
		newFile.addActionListener(newTab);
		newFile.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		JMenuItem open = new JMenuItem("Open");
		open.addActionListener(newTab);
		open.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		JMenuItem save = new JMenuItem("Save");
		ActionListener saveListener = new SaveListener(this, fileChooser, insert,
				this.tab);
		save.addActionListener(saveListener);
		save.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		
		
		//Check boxes for menus below?
		JCheckBoxMenuItem wrap = new JCheckBoxMenuItem("Auto-Wrap");
		ActionListener wrapListener = new WrapListener(this.tab, wrap);
		wrap.addActionListener(wrapListener);
		
		JCheckBoxMenuItem autoIndent = new JCheckBoxMenuItem("Auto-Indent");
		
		
		JMenuItem indent = new JMenuItem("Indent");
		
		
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
		
		JMenuItem bulletList = new JMenuItem("Bulleted List Tag");
		HTMLConstruct bulletTag = new BulletList();
		ActionListener bulletListener = new InsertListListener(this, bulletTag, this.tab);
		bulletList.addActionListener(bulletListener);
		list.add(bulletList);
		
		JMenuItem defineList = new JMenuItem("Defined List Tag");
		HTMLConstruct defineTag = new DefineList();
		ActionListener defineListener = new InsertListListener(this, defineTag, this.tab);
		defineList.addActionListener(defineListener);
		list.add(defineList);
		
		JMenuItem numberList = new JMenuItem("Numbered List Tag");
		HTMLConstruct numberTag = new NumberList();
		ActionListener numberListener = new InsertListListener(this, numberTag, this.tab);
		numberList.addActionListener(numberListener);
		list.add(numberList);
		
		//Table Menu
		JMenuItem table = new JMenuItem("Table Tag");
		HTMLConstruct tableTag = new Table();
		ActionListener tableListener = new InsertTableListener(this, tableTag, this.tab);
		table.addActionListener(tableListener);
		//End tag menus
		
		//Add Menus
		file.add(newFile);
		file.add(open);
		file.add(save);
		options.add(wrap);
		options.add(autoIndent);
		options.add(indent);
		
		insert.add(body);
		insert.add(div);
		insert.add(font);
		insert.add(header);
		insert.add(html);
		insert.add(list);
		insert.add(paragraph);
		insert.add(table);
		insert.add(title);
		
		
		//End add tag menus
		menuBar.add(file);
		menuBar.add(options);
		menuBar.add(insert);
		
		;
		
		//Main frame settings
		//LOOK FOR .HTML Files only!
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		tab.setVisible(false);
		this.add(tab);
		this.setJMenuBar(menuBar);
		this.setSize(400,400);
		this.setTitle("HTML Editor");
		
				
	}
	
}
