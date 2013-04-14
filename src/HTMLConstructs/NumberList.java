/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * @author Matthew Waite
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
		try{
			 NumberList nli = (NumberList) c;
			 if( size == nli.size && super.equals(nli)){
				 return true;
			 } else {
				 return false;
			 }
		}
		catch(ClassCastException exc){
			return false;
		}
		
        /*if( size == c.size && super.equals( c ) ){
			return true;
		}
		return false;*/
	}
}
