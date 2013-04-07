/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * Holds the tags and structure for a list with entry descriptions.
 */
public class DefineList extends HTMLConstruct{
	private int size;
	
	public DefineList(){
		size = 1;
		super.startTag = "<dl>";
		super.endTag = "</dl>";
	}
	
	public DefineList( int size ){
		this.size = size;
		super.startTag = "<dl>";
		super.endTag = "</dl>";
	}
	
	public String insert(){
		DefineListEntry dt = new DefineListEntry();
		String temp = startTag;
		while( size > 0 ){
			temp += "\n" + dt.insert();
			size--;
		}
		temp += "\n" + endTag;
		return temp;
	}
}
