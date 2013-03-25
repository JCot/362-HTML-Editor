/**
 * 
 */
package HTMLConstructs;

/**
 * @author ikeku_000
 *
 */
public class Table {
	String startTag = "<table>";
	String endTag = "</table>";
	
	public String insertTable( int rows, int cols ){
		ListEntry li = new ListEntry();
		String temp = startTag;
		while( rows >= 0 ){
			temp += "\n" + li.insert();
			rows--;
		}
		temp += "\n" + endTag;
		return temp;
	}
}
