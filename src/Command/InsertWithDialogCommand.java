/*
 * InsertListCommand.java
 * 
 */
package Command;

import javax.swing.JTabbedPane;

import GUI.EditorGUI;
import GUI.ObtainATagDialog;
import GUI.ObtainImgDialog;
import GUI.ObtainSizeDialog;
import GUI.ObtainTableDialog;
import HTMLConstructs.HTMLConstruct;

/**
 * Command for inserting an HTML tag with fields.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class InsertWithDialogCommand implements Command{
	
	private HTMLConstruct tag;
	private JTabbedPane tab;
	private EditorGUI frame;
	private String type;

	public InsertWithDialogCommand(HTMLConstruct tag, JTabbedPane tab,
			EditorGUI frame, String dialogType){
		this.tag = tag;
		this.tab = tab;
		this.frame = frame;
		this.type = dialogType;
	}

	public void execute(){
		if ((this.tab.getComponentCount()) != 0){
			if (this.type.equals("List")){
				ObtainSizeDialog dialog = new ObtainSizeDialog(this.frame, this.tab,
					this.tag);
			} else if (this.type.equals("Table")) {
				ObtainTableDialog dialog = new ObtainTableDialog(frame, this.tab,
						this.tag);
			} else if (this.type.equals("Img")) {
				ObtainImgDialog dialog = new ObtainImgDialog(this.frame, this.tab,
						this.tag);	
			} else if (this.type.equals("A")){
				ObtainATagDialog dialog = new ObtainATagDialog(this.frame, 
						this.tab, this.tag);	
			} else {
				System.out.println("OMG");
			}
			
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
