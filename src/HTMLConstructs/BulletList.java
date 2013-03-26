/**
 * 
 */
package HTMLConstructs;

/**
 * @author ikeku_000
 *
 */
public class BulletList extends HTMLConstruct{
	
	public BulletList() {
		super.startTag = "<ul>";
		super.endTag = "</ul>";
	}
	
	public String insertList( int size ){
		ListEntry li = new ListEntry();
		String temp = startTag;
		while( size > 0 ){
			temp += "\n" + li.insert();
			size--;
		}
		temp += "\n" + endTag;
		return temp;
	}
}
