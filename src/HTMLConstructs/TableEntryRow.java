/**
 * 
 */
package HTMLConstructs;

/**
 * @author ikeku_000
 *
 */
public class TableEntryRow extends HTMLConstruct{
	String startTag = "<tr>";
	String endTag = "</tr>";
	
	public String insert(){
		DefineListDef dd = new DefineListDef();
		String temp = startTag;
		temp += "\n" + dd.insert();
		temp += "\n" + endTag;
		return temp;
	}
}
