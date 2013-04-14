/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * Holds the tags and structure for a numbered list.
 */
public class NumberList extends HTMLConstruct{
	private int size;
	
	public NumberList() {
		size = 1;
		super.startTag = "<ol>";
		super.endTag = "</ol>";
	}
	
	public NumberList( HTMLConstruct parent, int size ) {
		this.size = size;
		super.parent = parent;
		super.startTag = "<ol>";
		super.endTag = "</ol>";
	}
	
	public String insert(){
		ListEntry li = new ListEntry();
		String temp = super.startTag;
		while( size > 0 ){
			temp += "\n" + li.insert();
			size--;
		}
		temp += "\n" + super.endTag;
		return temp;
	}
	
	@Override
	public void setSize(int size){
		this.size = size;
	}
	
	public boolean equals( HTMLConstruct c ){
		if( size == c.size && super.equals( c ) ){
			return true;
		}
		return false;
	}
}
