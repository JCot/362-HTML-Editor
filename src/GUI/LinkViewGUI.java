/*
 * LinkViewGUI.java
 * 
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import Editor.HtmlEditor;
import Editor.LinkViewModel;


/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class LinkViewGUI implements ActionListener {

	private LinkViewModel model;
	
	private JDialog dialog;

	private EditorGUI frame;
	
	private JTextArea text;
	
	private ButtonGroup group;
	
	private boolean displayByAppearance = true;
	
	public LinkViewGUI(EditorGUI frame){
		this.model = new LinkViewModel();
		this.dialog = new JDialog(frame, "Link View");
		this.frame = frame;
		this.text = new JTextArea();
		this.text.setEditable(false);
		
		//Main panel
		JPanel main = new JPanel(new GridLayout(2,0));
		JScrollPane scroll = new JScrollPane(this.text, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		main.add(scroll);
		
		//Panel for selecting apperance options
		JPanel options = new JPanel(new GridLayout(3,0));
		JLabel buttonLabel = new JLabel("Display URL's by: ");
		options.add(buttonLabel);
		
		@SuppressWarnings("serial")
		JRadioButton appearance = new JRadioButton( 
			new AbstractAction ("Order of Appearance") {
				public void actionPerformed(ActionEvent e){
					
					displayByAppearance = true;
				}
		});
		appearance.setSelected(true);
		
		@SuppressWarnings("serial")
		JRadioButton alphabetical = new JRadioButton( 
			new AbstractAction ("Alphabetical Order") {
				public void actionPerformed(ActionEvent e){
					
					displayByAppearance = false;
				}
		});
		
		this.group = new ButtonGroup();
		this.group.add(appearance);
		this.group.add(alphabetical);
		
		options.add(appearance);
		options.add(alphabetical);
		
		//Panel to combine options panel with a refresh button
		
		JPanel refreshPanel = new JPanel(new GridLayout(0,2));
		
		refreshPanel.add(options);
		
		JButton refresh = new JButton("Refresh");
		refresh.addActionListener(this);
		refreshPanel.add(refresh);
		
		main.add(refreshPanel);
		
		this.dialog.add(main);
		this.dialog.pack();
		this.dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.dialog.setVisible(false);
		
		
		
	}
	
	/**
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTabbedPane tab = this.frame.getTab();
		JScrollPane scroll = (JScrollPane) tab.getSelectedComponent();
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			String editorText = text.getText();
			this.update(editorText);
		}
		
	}
	
	public void update(String string){
		this.text.setText(null);
		if (this.displayByAppearance){
			String order = HtmlEditor.getOrderOfAppearanceLinks(string);
			this.text.insert(order,0);
		} else {
			String order = HtmlEditor.getOrderedLinks(string);
			this.text.insert(order,0);
		}
	}
	
	protected void setVisible(boolean visibility){
		this.dialog.setVisible(visibility);
	}
	
	
}
