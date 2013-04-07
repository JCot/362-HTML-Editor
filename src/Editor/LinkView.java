package Editor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * This is the backend class for the Link View.
 * It will keep a list of the links in the document
 * and be able to return them in the order requested.
 * @author Justin
 *
 */

public class LinkView {
	private ArrayList<String> links = new ArrayList<String>();
	private ArrayList<String> alphabeticalOrder = new ArrayList<String>();

	public LinkView(){}
	
	/**
	 * Takes a string and finds all the URLs in it.
	 * @param text
	 */
	public void findLinks(String text){
		String[] temp = text.split(" ");
		
		for(String s: temp){
			String noQuotes = "";
			if(s.contains("\"")){
				noQuotes = s.replaceAll("\"", "");
			}
			
			if(noQuotes.matches("^((https?|ftp)://|(www|ftp)\\.)[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$")){
				links.add(noQuotes);
				alphabeticalOrder.add(noQuotes);
			}
		}
		
		for(String p: links){
			System.out.println(p);
		}
	}
	
	/**
	 * 
	 * @return String temp - a string representation of all the URLs in
	 * the found by findLinks in the order they were found
	 */
	public String returnOrderofAppearance(){
		String temp = "";
		
		for(String s: links){
			temp += s + "\n";
		}
		
		return temp;
	}
	
	/**
	 * Sorts the URLs found by findLinks. Duplicates are not returned.
	 * Instead each unique URL has a counter that shows how many times
	 * it appears in the program.
	 * 
	 * @return String temp - a string representation of the URLs
	 * in alphabetical order
	 */
	public String returnOrdered(){
		String temp = "";
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> noDuplicates = new ArrayList<String>();
		
		Collections.sort(alphabeticalOrder);
		
		for(String s: alphabeticalOrder){
			if(!noDuplicates.contains(s)){
				noDuplicates.add(s);
				noDuplicates.add("1");
			}
			
			else{
				int index = noDuplicates.indexOf(s);
				int count = Integer.parseInt(noDuplicates.get(index + 1));
				
				count += 1;
				
				noDuplicates.set(index + 1, Integer.toString(count));
			}
		}
		
		for(int i = 0; i < noDuplicates.size() - 1; i++){
			if(i % 2 == 0){
				temp += noDuplicates.get(i) + ": " +
					noDuplicates.get(i + 1) + "\n";
			}
		}

		return temp;
	}

}
