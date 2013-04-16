package GUI;

/*
 * InsertListener.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import Command.UndoManager;

import Command.Command;
import Command.InsertCommand;
import Command.InsertWithDialogCommand;
import HTMLConstructs.HTMLConstruct;

/**
 * ActionListener for inserting a basic HTMLConstruct into the buffer.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class InsertListener implements ActionListener {
	/** Reference to the JTabbedPane */
	private JTabbedPane tab;
	
	/** Concrete Command object that will insert the tag when called */
	private Command insert;

	private EditorGUI frame;

	private HTMLConstruct tag;
	
	/**
	 * Constructor for an InsertListener, which inserts an HTML construct.
	 * Protected to ensure that only the GUI Package can construct one.
	 * 
	 * @param tag    HTMLConstruct represents a tag
	 * @param tab    JTabbedPane reference
	 */
	protected InsertListener(HTMLConstruct tag, JTabbedPane tab, EditorGUI frame) {
		this.tab = tab;
		this.tag = tag;
		this.frame = frame;
	}

	/**
	 * Specified by ActionListener, actionPerformed uses the JTabbedPane to
	 * obtain the current tab and then inserts the HTML tag at the current
	 * position.
	 * 
	 * @param arg0    ActionEvent describing the object calling this listener
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (this.tab.getTabCount() != 0){
			UndoManager manager = UndoManager.getInstance();
			int index = this.tab.getSelectedIndex();
			if (arg0.getActionCommand().equals("List")){
				Command insert = new InsertWithDialogCommand(this.tag, this.tab,
						this.frame, "List");
				insert.execute();
			} else if (arg0.getActionCommand().equals("Table")){
				Command insert = new InsertWithDialogCommand(this.tag, this.tab,
						this.frame, "Table");
				insert.execute();
			} else if (arg0.getActionCommand().equals("Img")) {
				Command insert = new InsertWithDialogCommand(this.tag, this.tab,
						this.frame, "Img");
				insert.execute();
			} else if (arg0.getActionCommand().equals("A")){
				Command insert = new InsertWithDialogCommand(this.tag, this.tab,
						this.frame, "A");
				insert.execute();
			} else {
				Command insert = new InsertCommand(tag, tab);
				insert.execute();
				manager.addCommand(index, insert);
				
			}
			
		}
	}

}
