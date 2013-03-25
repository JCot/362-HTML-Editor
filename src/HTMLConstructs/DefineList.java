/**
 * 
 */
package HTMLConstructs;

/**
 * @author ikeku_000
 *
 */
public class DefineList extends HTMLConstruct{
	String startTag = "<dl>";
	String endTag = "</dl>";
	
	public String insertList( int size ){
		DefineListEntry li = new DefineListEntry();
		String temp = startTag;
		while( size >= 0 ){
			temp += "\n" + li.insert();
			size--;
		}
		temp += "\n" + endTag;
		return temp;
	}
}
