package GUI;

/*
 * OKTableListener.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

import HTMLConstructs.HTMLConstruct;

/**
 * ActionListener that will take the user's desired table rows and columns
 * and then insert the proper table HTML tags into the document.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class OKTableListener implements ActionListener {

	/** Reference to the ObtainTableDialog */
	private ObtainTableDialog tableDialog;
	
	/** JTextField for the rows */
	private JTextField enteredRows;
	
	/** JTextField for the cols */
	private JTextField enteredCols;
	
	/** Reference to the previous dialog */
	private JDialog dialog;
	
	/** Reference to the EditorGUI */
	private EditorGUI gui;
	
	/**
	 * Constructor for an OKTableListener.  It will take the user's input and
	 * then insert the correct table HTML tag with rows and columns.
	 * 
	 * @param tableDialog
	 * @param rows
	 * @param gui
	 * @param cols
	 */
	protected OKTableListener(ObtainTableDialog tableDialog, JTextField rows, 
			EditorGUI gui, JTextField cols) {
		this.dialog = tableDialog.getDialog();
		this.enteredRows = rows;
		this.enteredCols = cols;
		this.tableDialog = tableDialog;
		this.gui = gui;
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed
	 * (java.awt.event.ActionEvent)
	 * 
	 * Specified by ActionListener, will take the user's input from the 
	 * text fields and then create the appropriate insert string to be inserted
	 * into the buffer.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		HTMLConstruct tag = this.tableDialog.getConstruct();
		JTabbedPane tab = this.tableDialog.getTabs();
		JScrollPane scroll = (JScrollPane) tab.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			String rowString = this.enteredRows.getText();
			String colString = this.enteredCols.getText();
			if (rowString.matches("\\d+") && colString.matches("\\d+")){
				int row = Integer.parseInt(rowString);
				int col = Integer.parseInt(colString);
				String insertTag = tag.insertTable(row, col);
				if (this.gui.getAutoIndent()){
					String indent = this.gui.getIndent();
					insertTag = indentTableComponents(insertTag, indent);
				}
				int position = text.getCaretPosition();
				text.insert(insertTag, position);
				this.dialog.dispose();
			}
		}

	}
	
	/*
	 * Given the insert string, will indent each line in the string to the
	 * proper nested format. 
	 */
	private String indentTableComponents(String insert, String indent){
		String temp = "";
		String[] lines = insert.split("\n");
		for(String line : lines){
			if(matchTableRowTag(line)){
				temp += (indent + line + "\n"); 
			} else if(matchTableColTag(line)){
				temp += (indent + indent + line + "\n");
			} else {
				temp += line + "\n";
			}
		}
		return temp;
	}
	
	/*
	 * Matches lines that start with a column tag.
	 */
	private boolean matchTableColTag(String line){
		if(line.startsWith("<td>") || line.startsWith("</td>")){
			return true;
		}
		return false;
	}
	
	/*
	 * Matches lines that start with a row tag.
	 */
	private boolean matchTableRowTag(String line){
		if(line.startsWith("<tr>") || line.startsWith("</tr>")){
			return true;
		}
		return false;
	}
}
