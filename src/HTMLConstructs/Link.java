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
	private String text;
	
	public Link(){
		url = "http://www.google.com";
		fill = "href = \"" + url + "\"";
		super.startTag = "<a " + fill + " >";
		super.endTag = "</a>";
	}
	
	public Link(String url, String text){
		this.url = url;
		fill = "href = \"" + url + "\"";
		this.text = text;
		super.startTag = "<a " + fill + " >";
		super.endTag = "</a>";
	}
	
	public Link( HTMLConstruct parent, String url, String text ){
		super.parent = parent;
		this.url = url;
		fill = "href = \"" + url + "\"";
		this.text = text;
		super.startTag = "<a " + fill + " >";
		super.endTag = "</a>";
	}
	
	public String insert(){
		String temp = startTag;
		temp += text + "\n\n" + endTag;
		return temp;
	}
	
	public String collapse(){
		expand = false;
		return "<a>";
	}

}