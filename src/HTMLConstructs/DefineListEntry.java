/**
 * 
 */
package HTMLConstructs;

/**
 * @author ikeku_000
 *
 */
public class DefineListEntry extends HTMLConstruct{
	
	public DefineListEntry() {
		super.startTag = "<dt>";
		super.endTag = "</dt>";
	}
	
	public String insert(){
		DefineListDef dd = new DefineListDef();
		String temp = startTag;
		temp += "\n" + dd.insert();
		temp += "\n" + endTag;
		return temp;
	}
}
