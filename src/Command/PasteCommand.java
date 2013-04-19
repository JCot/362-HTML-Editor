/*
 * PasteCommand.java
 * 
 */
package Command;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

/**
 * Command for pasting text.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class PasteCommand implements Command {

	
	private JTabbedPane tab;
	
	private String prevText;
	
	private int prevCursor;
	
	
	public PasteCommand(JTabbedPane tab) {
		this.tab = tab;
	}
	
	
	@Override
	public void execute() {
		JScrollPane scroll = (JScrollPane) this.tab.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			this.prevText = text.getText();
			this.prevCursor = text.getCaretPosition();
			text.paste();
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
