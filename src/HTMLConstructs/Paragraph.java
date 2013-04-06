/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * Holds the tags for a block of text in paragraph form.
 */
public class Paragraph extends HTMLConstruct{
	
	public Paragraph() {
		super.startTag = "<p>";
		super.endTag = "</p>";
	}

}
