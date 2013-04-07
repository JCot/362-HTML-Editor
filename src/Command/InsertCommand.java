package Command;

/*
 * InsertCommand.java
 * 
 */

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import HTMLConstructs.HTMLConstruct;

/**
 * Concrete command for inserting a basic HTML tag.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class InsertCommand implements Command {

	/** HTMLConstruct to insert into the JTextArea */
	private HTMLConstruct tag;
	
	/** Reference to the JTabbedPane containing the current text buffer*/
	private JTabbedPane tab;
	
	/**
	 * Constructor for an InsertCommand.  It requires the tag to be inserted 
	 * and the current tab where the text buffer is located, and when executed
	 * will insert the tag at the current position.
	 * 
	 * @param tag    HTMLConstruct representing the HTML tag
	 * @param tab    JTabbedPane containing the current text buffer
	 */
	public InsertCommand(HTMLConstruct tag, JTabbedPane tab) {
		this.tag = tag;
		this.tab = tab;
	}
	
	/**
	 * Inserts the HTML tag into the text buffer.
	 */
	public void execute() {
		JScrollPane scroll = (JScrollPane) this.tab.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			String insertTag = this.tag.insert();
			int position = text.getCaretPosition();
			text.insert(insertTag, position);
		}
	}
}
