package GUI;

/*
 * EnterListener.java
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

/**
 * KeyListener that listens for when newlines characters are typed, and
 * Auto-Indents if applicable.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class EnterListener implements KeyListener {

	/** EditorGUI Reference */
	private EditorGUI gui;
	
	/** Reference to the Tabbed Pane. */
	private JTabbedPane tab;
	
	/**
	 * Constructor for an EnterListener, which handles auto-indenting on 
	 * newline characters.  Protected to ensure that only the
	 * GUI Package can construct one.
	 * 
	 * @param gui    EditorGUI reference
	 * @param tab    JTabbedPane reference
	 */
	protected EnterListener(EditorGUI gui, JTabbedPane tab){
		this.gui = gui;
		this.tab = tab;
	}
	

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 * 
	 * Not implemented.
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 * 
	 * Not implemented.
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 * 
	 * Auto-Indent the new line if applicable.
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		if(arg0.getKeyChar() == '\n'){
			if (this.gui.getAutoIndent()){
				JScrollPane scroll = (JScrollPane) this.tab.getSelectedComponent();
				if (scroll != null){
					JViewport view = (JViewport) scroll.getComponent(0);
					JTextArea text = (JTextArea) view.getComponent(0);
					int position = text.getCaretPosition();
					String indent = this.gui.getIndent();
					text.insert(indent, position);
				}
			}
		}
		
	}

}
