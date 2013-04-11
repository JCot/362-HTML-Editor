/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * Holds the tags and structure for a bulleted list.
 */
public class BulletList extends HTMLConstruct{
	private int size;
	
	public BulletList(){
		size = 1;
		super.startTag = "<ul>";
		super.endTag = "</ul>";
	}
	
	public BulletList( int size ) {
		this.size = size;
		super.startTag = "<ul>";
		super.endTag = "</ul>";
	}
	
	public String insert(){
		ListEntry li = new ListEntry();
		String temp = startTag;
		while( size > 0 ){
			temp += "\n" + li.insert();
			size--;
		}
		temp += "\n" + endTag;
		return temp;
	}
	
	@Override
	public void setSize(int size){
		this.size = size;
	}
}
