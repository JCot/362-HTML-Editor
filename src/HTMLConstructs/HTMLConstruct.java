/**
 * 
 */
package HTMLConstructs;

/**
 * @author ikeku_000
 *
 */
public abstract class HTMLConstruct {
	protected String startTag;
	protected String endTag;
	
	public String insert(){
		String temp = "";
		temp += startTag + "\n\n" + endTag;
		return temp;
	}
	
	public String insertList(int size){
		return "";
	}
	
	public String insertTable( int rows, int cols ){
		return "";
	}
	
	public void add( HTMLConstruct c ){}
	
	public void remove( HTMLConstruct c ){}

	
	
}
