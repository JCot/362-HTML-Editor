/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * Holds the tags for an entry in a bulleted or numbered list.
 */
public class ListEntry extends HTMLConstruct{
	
	public ListEntry() {
		super.startTag = "<li>";
		super.endTag = "</li>";
	}

}
