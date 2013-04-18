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
	
	public Image() {
		url = "http://www.google.com";
		String alt = "There is no spoon.";
		int height = 100;
		int width = 100;
		fill = "src = \"" + url + "\" alt = \"" + alt + "\" height = \"" + height + "\" width = \"" + width + "\"";
		super.startTag = "<img " + fill + " >";
		super.endTag = "<img>";
	}
	
	public Image( HTMLConstruct parent, String url ){
		super.parent = parent;
		this.url = url;
		fill = "src = \"" + url + "\"" + " alt = \"This picture is unavailable.\"";
		super.startTag = "<img " + fill + " >";
		super.endTag = "<img>";
	}
	
	public Image( String url ){
		this.url = url;
		fill = "src = \"" + url + "\"" + " alt = \"This picture is unavailable.\"";
		super.startTag = "<img " + fill + " >";
		super.endTag = "<img>";
	}
	
	public Image( HTMLConstruct parent, String url, String alt, int height, int width ){
		super.parent = parent;
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
		expand = false;
		return endTag;
	}
}