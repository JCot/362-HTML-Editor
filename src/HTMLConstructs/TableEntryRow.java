/**
 * 
 */
package HTMLConstructs;

/**
 * @author ikeku_000
 *
 */
public class TableEntryRow extends HTMLConstruct{
	
	public TableEntryRow() {
		super.startTag = "<tr>";
		super.endTag = "</tr>";
	}
	
	public String insertTableRow( int cols ){
		TableEntryCol td = new TableEntryCol();
		String temp = super.startTag;
		while( cols > 0 ){
			temp += "\n" + td.insert();
			cols--;
		}
		temp += "\n" + super.endTag;
		return temp;
	}

}
