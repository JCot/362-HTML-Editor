/*
 * ObtainATagDialog.java
 * 
 */
package GUI;

import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

import Command.Command;
import Command.InsertCommand;
import Command.UndoManager;
import HTMLConstructs.HTMLConstruct;
import HTMLConstructs.Link;

/**
 * Dialog to obtain the fields for an A-tag.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class ObtainATagDialog implements ActionListener{

	private EditorGUI frame;
	private JTabbedPane tab;
	private HTMLConstruct construct;
	private JDialog dialog;
	private JTextField userText;
	private JTextField userUrl;

	public ObtainATagDialog(EditorGUI frame, JTabbedPane tab, 
			HTMLConstruct construct){
		
		this.frame = frame;
		this.tab = tab;
		this.construct = construct;
		this.dialog = new JDialog(this.frame, "Enter a URL",
				ModalityType.APPLICATION_MODAL);
		this.dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.userText = new JTextField();
		this.userUrl = new JTextField();
		
		JPanel overPanel = new JPanel(new GridLayout(5,0));
		JLabel url = new JLabel("Enter a URL");
		overPanel.add(url);
		overPanel.add(this.userUrl);
		
		JLabel text = new JLabel("Enter link text");
		overPanel.add(text);
		overPanel.add(this.userText);
		
		JPanel buttons = new JPanel(new GridLayout(0,2));
		JButton ok = new JButton("Ok");
		ok.addActionListener(this);
		
		JButton cancel = new JButton("Cancel");
		ActionListener cancelListener = new CancelListener(this.dialog);
		cancel.addActionListener(cancelListener);
		
		buttons.add(ok);
		buttons.add(cancel);
		overPanel.add(buttons);
		
		this.dialog.add(overPanel);
		this.dialog.pack();
		this.dialog.setVisible(true);
		
	}
	
	/**
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String urlString = this.userUrl.getText();
		String textString = this.userText.getText();
		this.construct = new Link(urlString, textString);
		Command command = new InsertCommand(this.construct, this.tab);
		int index = this.tab.getSelectedIndex();
		command.execute();
		UndoManager.getInstance().addCommand(index, command);	
		this.dialog.dispose();
		
	}

}
