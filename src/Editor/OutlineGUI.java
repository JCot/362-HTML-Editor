/*
 * OutlineGUI.java
 * 
 */
package Editor;

import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class OutlineGUI extends JFrame {

	public OutlineGUI(){
		
	}
	
	public boolean wellFormedCheck(String text){
		Stack<String> openTags = new Stack<String>();
		Stack<String> closeTags = new Stack<String>();
		String[] lines = text.split("\n");
		Stack<DefaultMutableTreeNode> parents = new Stack<DefaultMutableTreeNode>();
		boolean tagsWellFormed = false;
		
		for(int i = 0; i <= lines.length - 1; i++){
			String[] words = lines[i].split(" ");
			
			for(int j = 0; j <= words.length - 1; j++){
				String temp = words[j];
				
				if(temp.matches("<(\"[^\"]*\"|'[^']*'|[^'\">])*>")){
					if(!temp.contains("/")){
						openTags.add(temp);
						DefaultMutableTreeNode parent;
						try {
							parent = parents.peek();
						}
					}
					
					else{
						String newTemp = temp.replace("/", "");
						closeTags.add(temp);

						try{
							if(openTags.peek().equals(newTemp)){
								openTags.pop();
								closeTags.pop();
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
		}
		
		if(openTags.size() == 0 && closeTags.size() == 0){
			tagsWellFormed = true;
		}
		
		if(tagsWellFormed == true){
			return true;
		}
		
		return false;
	}
}
