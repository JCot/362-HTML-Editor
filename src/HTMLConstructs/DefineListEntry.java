/**
 * 
 */
package HTMLConstructs;

/**
 * @author ikeku_000
 *
 */
public class DefineListEntry extends HTMLConstruct{
	String startTag = "<dt>";
	String endTag = "</dt>";
	
	public String insert(){
		DefineListDef dd = new DefineListDef();
		String temp = startTag;
		temp += "\n" + dd.insert();
		temp += "\n" + endTag;
		return temp;
	}
}
