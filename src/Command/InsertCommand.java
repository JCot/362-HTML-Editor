package Command;

/*
 * InsertCommand.java
 * 
 */

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import Editor.AutoIndent;
import GUI.EditorGUI;
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
			
			if(AutoIndent.isOn){
				insertTag = AutoIndent.indent + insertTag;
				insertTag = AutoIndent.indentTags(insertTag);
			}
			
			this.prevText = text.getText();
			int position = text.getCaretPosition();
			this.prevCursor = position;
			text.insert(insertTag, position);
		}
	}

	/**
	 * 
	 */
	@Override
	public void undo() {
		JScrollPane scroll = (JScrollPane) this.tab.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			String replace = this.prevText;
			int prevPosition = this.prevCursor;
			text.setText(null);
			text.insert(replace, 0);
			text.setCaretPosition(prevPosition);
			String update = text.getText();
			EditorGUI.linkView.update(update);
		}
	}
	
}
