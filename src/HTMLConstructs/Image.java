/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * Holds the tags and structure for an image of certain size specifications.
 */
public class Image extends HTMLConstruct{
		private String url;
		private String fill;
		
	public Image( String url, String alt, int height, int width) {
		this.url = url;
		fill = "src = \"" + url + "\" alt = \"" + alt + "\" height = \"" + height + "\" width = \"" + width + "\"";
		super.startTag = "<img " + fill + " >";
		super.endTag = "<img>";
	}

	public String insert(){
		String temp = startTag;
		return temp;
	}

	public String collapse(){
		return endTag;
	}
}