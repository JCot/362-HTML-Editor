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
	
	@Override
	public String insertTable( int rows, int cols ){
		TableEntryRow tr = new TableEntryRow();
		String temp = super.startTag;
		while( rows > 0 ){
			temp += "\n" + tr.insertTableRow( cols );
			rows--;
		}
		temp += "\n" + super.endTag;
		return temp;
	}

}
