/*
 * OutlineGUI.java
 * 
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JViewport;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


/**
 * Prototype of the Outline Mode for Release 2.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class OutlineGUI extends JFrame implements ActionListener{
	
	private JScrollPane scroll= new JScrollPane();
	
	private JTabbedPane tab;

	public OutlineGUI(JTabbedPane tab){
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		this.tab = tab;
		String text = this.getCurrentText();
		
		JTree tree = this.parse(text);
		
		this.addTree(tree);
		this.add(this.scroll, BorderLayout.CENTER);
		
		JPanel button = new JPanel(new FlowLayout());
		JButton refresh = new JButton("Refresh");
		refresh.addActionListener(this);
		button.add(refresh);
		this.add(refresh, BorderLayout.SOUTH);
		
		this.pack();	
	}
	
	public JTree parse(String text){
		Stack<String> openTags = new Stack<String>();
		Stack<String> closeTags = new Stack<String>();
		String[] lines = text.split("\n");
		Stack<DefaultMutableTreeNode> parents = new Stack<DefaultMutableTreeNode>();
		DefaultMutableTreeNode hiddenParent = new DefaultMutableTreeNode();
		for(int i = 0; i <= lines.length - 1; i++){
			String temp = lines[i];

			if(temp.matches("<(\"[^\"]*\"|'[^']*'|[^'\">])*>")){
				DefaultMutableTreeNode parent;
				if(temp.contains("img")){
					try{
						parent = parents.peek();
					} catch(EmptyStackException e){
						parent = hiddenParent;
					}
					DefaultMutableTreeNode node = new DefaultMutableTreeNode(temp);
					parent.add(node);
				}
					
				else if(!temp.contains("/")){
					try{
						parent = parents.peek();
					} catch(EmptyStackException e){
						parent = hiddenParent;
					}
					DefaultMutableTreeNode node;
					if(temp.contains("html")){
						node = new DefaultMutableTreeNode("html");
					} else {
						node = new DefaultMutableTreeNode(temp);
					}
					parent.add(node);
					parents.add(node);
					openTags.add(temp);
				}

				else{
					String newTemp = temp.replace("/", "");
					newTemp = newTemp.substring(0, newTemp.length() - 1);
					closeTags.add(temp);

					try{
						if(openTags.peek().contains(newTemp)){
							openTags.pop();
							closeTags.pop();
							parents.pop();
						}

						else{
							break;
						}
					}

					catch(EmptyStackException e){
						break;
					}
				}
			}
		}
		
		JTree tree = new JTree(hiddenParent);
		tree.setRootVisible(false);
		return tree;
	}
	
	private String getCurrentText(){
		JScrollPane scroll = (JScrollPane) this.tab.getSelectedComponent();
		String temp = "";
		if (scroll != null){
			JViewport view = (JViewport) scroll.getComponent(0);
			JTextArea text = (JTextArea) view.getComponent(0);
			temp = text.getText();
		}
		return temp;
	}

	private void addTree(JTree tree){
		
		
		Icon customOpenIcon = new ImageIcon(getClass().getResource("/resource/minusButton.gif"));
		Icon customClosedIcon = new ImageIcon(getClass().getResource("/resource/plusButton.gif"));
		DefaultTreeCellRenderer aRenderer = new DefaultTreeCellRenderer();
	    aRenderer.setOpenIcon(customOpenIcon);
	    aRenderer.setClosedIcon(customClosedIcon);
	    aRenderer.setLeafIcon(null);
	    tree.setCellRenderer(aRenderer);
		this.scroll.setViewportView(tree);
		
		
		
	}
	
	/**
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String text = this.getCurrentText();
		JTree tree = this.parse(text);
		this.addTree(tree);	
	}
}
