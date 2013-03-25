/**
 * 
 */
package HTMLConstructs;

/**
 * @author ikeku_000
 *
 */
public class NumberList extends HTMLConstruct{
	String startTag = "<ol>";
	String endTag = "</ol>";
	
	public String insertList( int size ){
		ListEntry li = new ListEntry();
		String temp = startTag;
		while( size >= 0 ){
			temp += "\n" + li.insert();
			size--;
		}
		temp += "\n" + endTag;
		return temp;
	}
}
