/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * Holds the tags for a list entry description.
 */
public class DefineListDef extends HTMLConstruct{
	
	public DefineListDef(){
		super.startTag = "<dd>";
		super.endTag = "</dd>";
	}
	
	public DefineListDef( HTMLConstruct parent ){
		super.parent = parent;
		super.startTag = "<dd>";
		super.endTag = "</dd>";
	}
	
}
