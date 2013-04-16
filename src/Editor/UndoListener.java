/*
 * UndoListener.java
 * 
 */
package Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import Command.UndoManager;
import GUI.EditorGUI;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class UndoListener implements ActionListener {
	
	private EditorGUI frame;
	
	public UndoListener(EditorGUI frame){
		this.frame = frame;
	}
	
	/**
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JScrollPane scroll = (JScrollPane) this.frame.getTab()
				.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			int index = this.frame.getTab().getSelectedIndex();
			UndoManager manager = UndoManager.getInstance();
			manager.processUndo(index);
		}

	}

}
