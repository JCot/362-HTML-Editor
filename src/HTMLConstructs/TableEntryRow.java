/**
 * 
 */
package HTMLConstructs;

/**
 * @author ikeku_000
 *
 */
public class TableEntryRow extends HTMLConstruct{
	
	public TableEntryRow() {
		super.startTag = "<tr>";
		super.endTag = "</tr>";
	}
	
	public String insert(){
		DefineListDef dd = new DefineListDef();
		String temp = super.startTag;
		temp += "\n" + dd.insert();
		temp += "\n" + super.endTag;
		return temp;
	}
}
