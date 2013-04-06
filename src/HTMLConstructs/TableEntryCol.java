/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * Holds the tags and structure for a single cell in a table.
 */
public class TableEntryCol extends HTMLConstruct{
	
	public TableEntryCol() {
		super.startTag = "<td>";
		super.endTag = "</td>";
	}

}
