/**
 * 
 */
package HTMLConstructs;

/**
 * @author ikeku_000
 *
 */
public class NumberList extends HTMLConstruct{
	public NumberList() {
		super.startTag = "<ol>";
		super.endTag = "</ol>";
	}
	
	public String insertList( int size ){
		ListEntry li = new ListEntry();
		String temp = super.startTag;
		while( size >= 0 ){
			temp += "\n" + li.insert();
			size--;
		}
		temp += "\n" + super.endTag;
		return temp;
	}
}
