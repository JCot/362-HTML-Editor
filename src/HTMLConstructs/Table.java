/**
 * 
 */
package HTMLConstructs;

/**
 * @author ikeku_000
 *
 */
public class Table extends HTMLConstruct{
	public Table() {
		super.startTag = "<table>";
		super.endTag = "</table>";
	}
	
	public String insertTable( int rows, int cols ){
		ListEntry li = new ListEntry();
		String temp = super.startTag;
		while( rows >= 0 ){
			temp += "\n" + li.insert();
			rows--;
		}
		temp += "\n" + super.endTag;
		return temp;
	}
}
