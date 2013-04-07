/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * Holds the tags and structure for an ordinary hyperlink.
 */
public class Link extends HTMLConstruct{
	private String url;
	private String fill;
	
	public Link(){
		url = "http://www.google.com";
		fill = "href = \"" + url + "\"";
		super.startTag = "<a " + fill + " >";
		super.endTag = "</a>";
	}
	
	public Link( String url ){
		this.url = url;
		fill = "href = \"" + url + "\"";
		super.startTag = "<a " + fill + " >";
		super.endTag = "</a>";
	}
	
	public String insert(){
		String temp = startTag;
		temp += "\n\n" + endTag;
		return temp;
	}
	
	public String collapse(){
		expand = false;
		return "<a>";
	}

}