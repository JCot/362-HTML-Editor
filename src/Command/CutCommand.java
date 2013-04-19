package Command;

/*
 * CutCommand.java
 * 
 */

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import Editor.HtmlEditor;


/**
 * Command for cutting selected text.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class CutCommand implements Command {

	
	/** Reference to the JTabbedPane containing the current text buffer*/
	private JTabbedPane tab;
	
	private String prevText;
	
	private int prevCursor;
	
	
	/**
	 * @param tab    JTabbedPane containing the current text buffer
	 */
	public CutCommand(JTabbedPane tab) {
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
			this.prevText = text.getText();
			this.prevCursor = text.getCaretPosition();
			HtmlEditor.clipboard = text.getSelectedText();
			text.cut();
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
			text.setText(null);
			text.insert(this.prevText, 0);
			text.setCaretPosition(prevCursor);
		}
	}

}