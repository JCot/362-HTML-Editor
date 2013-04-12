/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * Holds a string of text which can be inside any tag.
 */
public class Text extends HTMLConstruct{
	String text;
	
	public void setText( String text ){
		this.text = text;
	}
	
	public String getText(){
		return text;
	}

}
