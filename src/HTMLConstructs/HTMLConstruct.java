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
	
	protected void setStart(String start){
		this.startTag = start;
	}
	
	protected void setEnd(String end){
		this.endTag = end;
	}
	
	
	public void add( HTMLConstruct c ){}
	
	public void remove( HTMLConstruct c ){}
}
