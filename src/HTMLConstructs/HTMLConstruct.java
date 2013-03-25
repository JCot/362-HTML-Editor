/**
 * 
 */
package HTMLConstructs;

/**
 * @author ikeku_000
 *
 */
public abstract class HTMLConstruct {
	private String startTag;
	private String endTag;
	
	public String insert(){
		String temp = "";
		temp += startTag + "\n\n" + endTag;
		return temp;
	}
	
	public void add( HTMLConstruct c ){}
	
	public void remove( HTMLConstruct c ){}
}
