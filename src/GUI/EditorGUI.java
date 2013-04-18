package GUI;

/*
 * EditorGUI.java 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import Command.Command;
import Command.CutCommand;
import Command.PasteCommand;
import Command.UndoManager;
import Editor.AutoIndent;
import Editor.HtmlEditor;
import Editor.OutlineGUI;
import HTMLConstructs.*;

/**
 * Main GUI class.  Handles the entire GUI.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class EditorGUI extends JFrame {
	
	/** Reference to the JTabbedPane used by the GUI. */
	private JTabbedPane tab;
	
	/** Reference to the insert menu which may be disabled */
	private JMenu insert;
	
	public static LinkViewGUI linkView;
	
	/**
	 * Constructor for an EditorGUI object.  Creates the main GUI. 
	 */
	public EditorGUI() {
		
		//Initialize various components
		final JTabbedPane tab = new JTabbedPane();
		this.tab = tab;
		final JFileChooser fileChooser = new JFileChooser();
		this.linkView = new LinkViewGUI(this);
		
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
		
		
		//Options Menus
		JCheckBoxMenuItem wrap = new JCheckBoxMenuItem("Auto-Wrap");
		ActionListener wrapListener = new WrapListener(this.tab, wrap);
		wrap.addActionListener(wrapListener);
		
		JCheckBoxMenuItem autoIndent = new JCheckBoxMenuItem("Auto-Indent");
		ActionListener autoListener = new AutoIndentListener(autoIndent, this);
		autoIndent.addActionListener(autoListener);
		
		JMenuItem indent = new JMenuItem("Indent");
		ActionListener indentListener = new IndentListener(this, this.tab);
		indent.addActionListener(indentListener);
		
		
		//Basic Tags
		JMenuItem body = new JMenuItem("Body");
		HTMLConstruct bodyTag = new Body();
		ActionListener bodyListener = new InsertListener(bodyTag, this.tab, 
				this);
		body.addActionListener(bodyListener);
		
		JMenuItem html = new JMenuItem("HTML");
		HTMLConstruct htmlTag = new HTML();
		ActionListener htmlListener = new InsertListener(htmlTag, this.tab, 
				this);
		html.addActionListener(htmlListener);
		
		JMenuItem div = new JMenuItem("Div");
		HTMLConstruct divTag = new Div();
		ActionListener divListener = new InsertListener(divTag, this.tab, 
				this);
		div.addActionListener(divListener);
		
		JMenuItem header = new JMenuItem("Header");
		HTMLConstruct headerTag = new Header();
		ActionListener headerListener = new InsertListener(headerTag, this.tab, 
				this);
		header.addActionListener(headerListener);
		
		JMenuItem paragraph = new JMenuItem("Paragraph");
		HTMLConstruct paragraphTag = new Paragraph();
		ActionListener paragraphListener = new InsertListener(paragraphTag, this.tab,
				this);
		paragraph.addActionListener(paragraphListener);
		
		JMenuItem title = new JMenuItem("Title");
		HTMLConstruct titleTag = new Title();
		ActionListener titleListener = new InsertListener(titleTag, this.tab, 
				this);
		title.addActionListener(titleListener);
		
		
		//Font Menus
		JMenu font = new JMenu ("Font Tags");
		
		JMenuItem bold = new JMenuItem("Bold");
		HTMLConstruct boldTag = new Bold();
		ActionListener boldListener = new InsertListener(boldTag, this.tab, 
				this);
		bold.addActionListener(boldListener);
		font.add(bold);
		
		JMenuItem italic = new JMenuItem("Italic");
		HTMLConstruct italicTag = new Italic();
		ActionListener italicListener = new InsertListener(italicTag, this.tab,
				this);
		italic.addActionListener(italicListener);
		font.add(italic);
		
		
		//List Menus
		JMenu list = new JMenu("List Tags");
		
		JMenuItem bulletList = new JMenuItem("Bulleted List Tag");
		HTMLConstruct bulletTag = new BulletList();
		ActionListener bulletListener = new InsertListener(bulletTag, this.tab, 
				this);
		bulletList.addActionListener(bulletListener);
		bulletList.setActionCommand("List");
		list.add(bulletList);
		
		JMenuItem defineList = new JMenuItem("Defined List Tag");
		HTMLConstruct defineTag = new DefineList();
		ActionListener defineListener = new InsertListener(defineTag, this.tab,
				this);
		defineList.addActionListener(defineListener);
		defineList.setActionCommand("List");
		list.add(defineList);
		
		JMenuItem numberList = new JMenuItem("Numbered List Tag");
		HTMLConstruct numberTag = new NumberList();
		ActionListener numberListener = new InsertListener(numberTag, this.tab,
				this);
		numberList.addActionListener(numberListener);
		numberList.setActionCommand("List");
		list.add(numberList);
		
		//Table Menu
		JMenuItem table = new JMenuItem("Table Tag");
		HTMLConstruct tableTag = new Table();
		ActionListener tableListener = new InsertListener(tableTag, this.tab, this);
		table.setActionCommand("Table");
		table.addActionListener(tableListener);
		
		//Header Menus
		
		JMenu hTags = new JMenu("H Tags");
		
		JMenuItem h1 = new JMenuItem("H1 Tag");
		HTMLConstruct h1Tag = new Heading1();
		ActionListener h1Listener = new InsertListener(h1Tag, this.tab, this);
		h1.addActionListener(h1Listener);
		hTags.add(h1);
		
		JMenuItem h2 = new JMenuItem("H2 Tag");
		HTMLConstruct h2Tag = new Heading2();
		ActionListener h2Listener = new InsertListener(h2Tag, this.tab, this);
		h2.addActionListener(h2Listener);
		hTags.add(h2);
		
		JMenuItem h3 = new JMenuItem("H3 Tag");
		HTMLConstruct h3Tag = new Heading3();
		ActionListener h3Listener = new InsertListener(h3Tag, this.tab, this);
		h3.addActionListener(h3Listener);
		hTags.add(h3);
		
		JMenuItem h4 = new JMenuItem("H4 Tag");
		HTMLConstruct h4Tag = new Heading4();
		ActionListener h4Listener = new InsertListener(h4Tag, this.tab, this);
		h4.addActionListener(h4Listener);
		hTags.add(h4);
		
		JMenuItem h5 = new JMenuItem("H5 Tag");
		HTMLConstruct h5Tag = new Heading5();
		ActionListener h5Listener = new InsertListener(h5Tag, this.tab, this);
		h5.addActionListener(h5Listener);
		hTags.add(h5);
		
		JMenuItem h6 = new JMenuItem("H6 Tag");
		HTMLConstruct h6Tag = new Heading6();
		ActionListener h6Listener = new InsertListener(h6Tag, this.tab, this);
		h6.addActionListener(h6Listener);
		hTags.add(h6);
		
		//IMG tag
		JMenuItem img = new JMenuItem ("Img Tag");
		HTMLConstruct imgTag = new Image();
		ActionListener imgListener = new InsertListener(imgTag, this.tab, this);
		img.setActionCommand("Img");
		img.addActionListener(imgListener);
		
		//'a' tag
		JMenuItem link = new JMenuItem ("'A' Tag");
		HTMLConstruct aTag = new Link();
		ActionListener aListener = new InsertListener(aTag, this.tab, this);
		link.setActionCommand("A");
		link.addActionListener(aListener);
		//End tag menus
		
		//View Mwnu
		JMenu view = new JMenu("View");
		JCheckBoxMenuItem linked = new JCheckBoxMenuItem("Link View");
		ActionListener linkedListener = new LinkViewListener(linked, this);
		linked.addActionListener(linkedListener);
		
		JMenuItem outline = new JMenuItem("Outline View");
		outline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				JScrollPane scroll = (JScrollPane) tab.getSelectedComponent();
				if (scroll != null){
					JViewport view = (JViewport) scroll.getComponent(0);
					JTextArea text = (JTextArea) view.getComponent(0);
					OutlineGUI gui = new OutlineGUI(tab);
				}
			}
		});
		
		view.add(linked); 
		view.add(outline);
		
		
		//Edit Menu
		JMenu edit = new JMenu("Edit");
		JMenuItem cut = new JMenuItem("Cut");
		cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				int index = tab.getSelectedIndex();
				Command cut = new CutCommand(tab);
				cut.execute();
				if(HtmlEditor.clipboard != null){
					UndoManager.getInstance().addCommand(index, cut);
				}
			}
		});
		edit.add(cut);
		
		JMenuItem paste = new JMenuItem("Paste");
		paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				int index = tab.getSelectedIndex();
				Command paste = new PasteCommand(tab);
				paste.execute();
				UndoManager.getInstance().addCommand(index, paste);
				
			}
		});
		edit.add(paste);
		
		
		
		JMenuItem undo = new JMenuItem("Undo");
		ActionListener undoListener = new UndoListener(this);
		undo.addActionListener(undoListener);
		edit.add(undo);
		
		
		
		//Add Menus to GUI
		file.add(newFile);
		file.add(open);
		file.add(save);
		options.add(wrap);
		options.add(autoIndent);
		options.add(indent);
		
		insert.add(link);
		insert.add(body);
		insert.add(div);
		insert.add(font);
		insert.add(hTags);
		insert.add(header);
		insert.add(html);
		insert.add(img);
		insert.add(list);
		insert.add(paragraph);
		insert.add(table);
		insert.add(title);
		
		this.insert = insert;
		
		//End add tag menus
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(options);
		menuBar.add(insert);
		menuBar.add(view);
		
		;
		
		//Main frame settings
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		tab.setVisible(false);
		this.add(tab);
		this.setJMenuBar(menuBar);
		this.setSize(400,400);
		this.setTitle("HTML Editor");
		
	}
	
	/**
	 * Gets the New Tab ActionListener.  Used to open tabs with files passed
	 * in as command line arguments.
	 * @return tab    JTabbedPane tracking different text buffers
	 */
	public JTabbedPane getTab(){
		return this.tab;
	}
	
	/**
	 * Gets the insert menu which will be disabled/enabled.
	 * 
	 * @return insert    JMenu for inserting tags
	 */
	public JMenu getInsertMenu() {
		return this.insert;
	}
	
	public LinkViewGUI getLinkView(){
		return this.linkView;
	}
	
}
