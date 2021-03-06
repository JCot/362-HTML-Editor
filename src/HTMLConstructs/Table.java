/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * Holds the tags and structure for a table.
 */
public class Table extends HTMLConstruct{
	private int rows;
	private int cols;
	
	public Table() {
		rows = 1;
		cols = 1;
		super.startTag = "<table>";
		super.endTag = "</table>";
	}
	
	public Table( HTMLConstruct parent, int rows, int cols ) {
		this.rows = rows;
		this.cols = cols;
		super.parent = parent;
		super.startTag = "<table>";
		super.endTag = "</table>";
	}
	
	public Table( int rows, int cols ) {
		this.rows = rows;
		this.cols = cols;
		super.startTag = "<table>";
		super.endTag = "</table>";
	}
	
	@Override
	public String insert(){
		TableEntryRow tr = new TableEntryRow( this, cols );
		String temp = super.startTag;
		int current = this.rows;
		while( current > 0 ){
			temp += "\n" + tr.insert();
			current--;
		}
		temp += "\n" + super.endTag;
		return temp;
	}

}
