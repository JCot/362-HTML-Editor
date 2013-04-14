/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * Holds a string of text which can be inside any tag.
 */
public class Text extends HTMLConstruct{
	public String text;
	
	public Text(){
		super.startTag = "";
		super.endTag = "";
	}
	
	public void setText( String text ){
		this.text = text;
	}
	
	public String getText(){
		return text;
	}
	
	public boolean equals( HTMLConstruct c ){
		try{
			Text t = (Text)c;
			if( text.equals( t.text )){
				return true;
			} else {
				return false;
			}
		}
		catch(ClassCastException exc){
			return false;
		}
		/*if( startTag.equals( c.startTag ) && endTag.equals( c.endTag ) ){
			if( text.equals( c.text ) ){
				return true;
			}
		}
		return false;*/
	}

}
