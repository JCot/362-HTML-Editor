package GUI;

/*
 * ObtainIndentDialog.java
 * 
 */


import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import HTMLConstructs.HTMLConstruct;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class ObtainIndentDialog {

	private JPanel panel;
	private JTextField userNumber;
	private JDialog dialog;
		
	protected ObtainIndentDialog(EditorGUI frame){
		
		this.dialog = new JDialog(frame, "Enter Indent Spacing",
				ModalityType.APPLICATION_MODAL);
		this.dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.panel = new JPanel(new GridLayout(3,0));
		JLabel message = new JLabel();
		message.setText("Enter the number of spaces to indent:");
		this.userNumber = new JTextField();
		
		JPanel buttons = new JPanel(new GridLayout(0,2));
		JButton okButton = new JButton("Ok");
		ActionListener okListener = new OKIndentSpaceListener(this, 
				this.dialog, this.userNumber, frame);
		okButton.addActionListener(okListener);
		
		JButton cancelButton = new JButton("Cancel");
		ActionListener cancelListener = new CancelListener(this.dialog);
		cancelButton.addActionListener(cancelListener);
		
		buttons.add(okButton);
		buttons.add(cancelButton);

		this.panel.add(message);
		this.panel.add(this.userNumber);
		this.panel.add(buttons);

		this.dialog.add(this.panel);
		this.dialog.pack();
		this.dialog.setVisible(true);
	}
	
	
}
