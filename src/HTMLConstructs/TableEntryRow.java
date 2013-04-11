/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * Holds the tags and structure for a single row in a table.
 */
public class TableEntryRow extends HTMLConstruct{
	private int cols;
	
	public TableEntryRow() {
		cols = 1;
		super.startTag = "<tr>";
		super.endTag = "</tr>";
	}
	
	public TableEntryRow( int cols ) {
		this.cols = cols;
		super.startTag = "<tr>";
		super.endTag = "</tr>";
	}
	
	public String insert(){
		TableEntryCol td = new TableEntryCol();
		String temp = super.startTag;
		int current = this.cols;
		while( current > 0 ){
			temp += "\n" + td.insert();
			current--;
		}
		temp += "\n" + super.endTag;
		
		return temp;
	}

}
