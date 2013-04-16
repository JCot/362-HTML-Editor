/*
 * CutCommand.java
 * 
 */
package Command;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import HTMLConstructs.HTMLConstruct;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class CutCommand implements Command {

	/** HTMLConstruct to insert into the JTextArea */
	private HTMLConstruct tag;
	
	/** Reference to the JTabbedPane containing the current text buffer*/
	private JTabbedPane tab;
	
	private String prevText;
	
	private int prevCursor;
	
	
	/**
	 * Constructor for an InsertCommand.  It requires the tag to be inserted 
	 * and the current tab where the text buffer is located, and when executed
	 * will insert the tag at the current position.
	 * 
	 * @param tag    HTMLConstruct representing the HTML tag
	 * @param tab    JTabbedPane containing the current text buffer
	 */
	public CutCommand(HTMLConstruct tag, JTabbedPane tab, String prevString) {
		this.tag = tag;
		this.tab = tab;
	}
	
	/**
	 * 
	 */
	@Override
	public void execute() {
		JScrollPane scroll = (JScrollPane) this.tab.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
		}
	}



	/**
	 * 
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}