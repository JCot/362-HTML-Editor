package Editor;
import java.util.ArrayList;
import java.util.Collections;

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
	
	public void findLinks(String text){
		String[] temp = text.split(" ");
		
		for(String s: temp){
			if(s.matches("^((https?|ftp)://|(www|ftp)\\.)[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$")){
				links.add(s);
				alphabeticalOrder.add(s);
			}
		}
	}
	
	public String returnOrderofAppearance(){
		String temp = "";
		
		for(String s: links){
			temp += s + "\n";
		}
		
		return temp;
	}
	
	public String returnOrdered(){
		String temp = "";
		
		Collections.sort(alphabeticalOrder);
		
		
		
		for(String s: alphabeticalOrder){
			temp += s + "\n";
		}
		
		return temp;
	}

}
