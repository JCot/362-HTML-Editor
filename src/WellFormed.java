/**
 * This is the class used to make sure a document is well-formed before
 * it is opened and before it is saved.
 */

import java.util.*;

/**
 * @author Justin Cotner, jdc9622
 *
 */
public class WellFormed {
	
	int numOpenTags = 0;
	int numCloseTags = 0;
	
	public WellFormed(){}
	
	public boolean wellFormedCheck(String text){
		Stack<String> openTags = new Stack<String>();
		Stack<String> closeTags = new Stack<String>();
		String[] lines = text.split(System.getProperty("line.separator"));
		boolean tagsWellFormed = false;
		
		for(int i = 0; i <= lines.length - 1; i++){
			String[] words = lines[i].split(" ");
			
			for(int j = 0; j <= words.length - 1; j++){
				String temp = words[j];
				
				if(temp.matches("<(\"[^\"]*\"|'[^']*'|[^'\">])*>")){
					if(!temp.contains("/")){
						openTags.add(temp);
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