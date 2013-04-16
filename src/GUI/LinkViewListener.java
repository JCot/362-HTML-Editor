/*
 * LinkViewListener.java
 * 
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class LinkViewListener implements ActionListener {

	private JCheckBoxMenuItem menu;
	private EditorGUI frame;

	public LinkViewListener(JCheckBoxMenuItem menu, EditorGUI frame){
		this.menu = menu;
		this.frame = frame;
	}
	
	/**
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		LinkViewGUI gui = this.frame.getLinkView();
		JScrollPane scroll = (JScrollPane) 
				this.frame.getTab().getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			String textString = text.getText();
			if (this.menu.getState()) {
				gui.update(textString);
				gui.setVisible(true);
			} else {
				gui.setVisible(false);
			}
		}

	}

}
