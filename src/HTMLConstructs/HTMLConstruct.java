/**
 * 
 */
package HTMLConstructs;

import java.util.ArrayList;

/**
 * @author Isaac Kunkel
 * This is the Component abstract superclass for all HTML tags.
 */
public abstract class HTMLConstruct {
	protected boolean expand = true;
	protected String startTag;
	protected String endTag;
	public ArrayList<HTMLConstruct> children = new ArrayList<HTMLConstruct>();
	protected HTMLConstruct parent;
	
	public HTMLConstruct(){}
	
	public HTMLConstruct( HTMLConstruct parent ){
		this.parent = parent;
	}
	
	public String insert(){
		String temp = "";
		temp += startTag + "\n\n" + endTag;
		return temp;
	}
	
	public String collapse(){
		expand = false;
		return startTag;
	}
	
	public void setSize(int size){
		
	}
	
	public void setTableSize(int row, int col){
		
	}
	
	public boolean equals( HTMLConstruct c ){
		if( this.startTag.equals( c.startTag )&& this.endTag.equals( c.endTag ) ){
			for( int i = 0 ; i < children.size(); i++ ){
				if(! children.get( i ).equals( c.children.get( i ) ) ){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	/**public String insertList(int size){
		return "";
	}
	
	public String insertTable( int rows, int cols ){
		return "";
	}
	
	public String insertImage( String alt, int height, int width ){
		return "";
	}
	
	public String insertLink( String url ){
		return "";
	}
	
	public void add( HTMLConstruct c ){}
	
	public void remove( HTMLConstruct c ){}
	*/
		
}
