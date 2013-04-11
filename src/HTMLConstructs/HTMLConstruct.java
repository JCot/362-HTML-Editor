/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * This is the Component abstract superclass for all HTML tags.
 */
public abstract class HTMLConstruct {
	protected boolean expand = true;
	protected String startTag;
	protected String endTag;
	
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
