package Editor;

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
	
	public WellFormed(){}
	
	/**
	 * Takes a String and checks to make sure it conforms to
	 * well formed HTML standards. Right now only checks for
	 * start tags without end tags, end tags without start tags,
	 * and overlapping elements.
	 * 
	 * @param String text - the text to be checked
	 * @return true if the text is well formed false
	 * otherwise
	 */
	public boolean wellFormedCheck(String text){
		Stack<String> openTags = new Stack<String>();
		Stack<String> closeTags = new Stack<String>();
		String[] lines = text.split("\n");
		boolean tagsWellFormed = false;
		
		for(int i = 0; i <= lines.length - 1; i++){
			String temp = lines[i];

			if(temp.matches("<(\"[^\"]*\"|'[^']*'|[^'\">])*>")){
				if(temp.contains("img")){}
				
				else if(!temp.contains("/")){
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
		
		if(openTags.size() == 0 && closeTags.size() == 0){
			tagsWellFormed = true;
		}
		
		if(tagsWellFormed == true){
			return true;
		}
		
		return false;
	}

}