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
 * A dialog used to obtain the user's desired amount of spaces to 
 * use as an indent.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class ObtainIndentDialog {

	/** JPanel to hold the dialog's components */
	private JPanel panel;
	
	/** JTextField that holds the user's entry */
	private JTextField userNumber;
	
	/** JDialog that will be created upon instantiation */
	private JDialog dialog;
	
	/**
	 * Constructor for ObtainIndentDialog, which will display the dialog
	 * for specifying the number of spaces to indent a selection by.
	 * Protected to ensure that only the GUI Package can construct one.
	 * @param frame    EditorGUI reference
	 */
	protected ObtainIndentDialog(EditorGUI frame){
		
		//Initialize JDialog
		this.dialog = new JDialog(frame, "Enter Indent Spacing",
				ModalityType.APPLICATION_MODAL);
		this.dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Initialize panel
		this.panel = new JPanel(new GridLayout(3,0));
		JLabel message = new JLabel();
		message.setText("Enter the number of spaces to indent:");
		this.userNumber = new JTextField();
		
		//Initialize buttons on the dialog
		JPanel buttons = new JPanel(new GridLayout(0,2));
		JButton okButton = new JButton("Ok");
		ActionListener okListener = new OKIndentSpaceListener(this, 
				this.dialog, this.userNumber, frame);
		okButton.addActionListener(okListener);
		
		JButton cancelButton = new JButton("Cancel");
		ActionListener cancelListener = new CancelListener(this.dialog);
		cancelButton.addActionListener(cancelListener);
		
		//Combine all the components into the dialog
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
