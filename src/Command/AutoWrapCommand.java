package Command;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

/*
 * AutoWrapCommand.java
 * 
 */


/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class AutoWrapCommand implements Command {
	
	/** Reference to the JTabbedPane */
	private JTabbedPane tab;
	
	/** Reference to the Check Box Menu */
	private JCheckBoxMenuItem check;

	public AutoWrapCommand(JTabbedPane tab, JCheckBoxMenuItem chec){
		this.tab = tab;
		this.check = check;
	}

	/**
	 * 
	 */
	@Override
	public void execute() {
		boolean state = this.check.getState();
		JScrollPane scroll = (JScrollPane) this.tab.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			text.setWrapStyleWord(true);
			text.setLineWrap(state);
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
