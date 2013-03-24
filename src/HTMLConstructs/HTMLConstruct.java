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
	
	public String insert( HTMLConstruct c ){
		String temp = "";
		temp += c.startTag + "\n\n" + c.endTag;
		return temp;
	}
	
	public void add( HTMLConstruct c ){}
	
	public void remove( HTMLConstruct c ){}
}
