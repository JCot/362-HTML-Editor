/**
 * 
 */
package HTMLConstructs;
import java.util.ArrayList;

/**
 * @author Isaac Kunkel
 * This is a general Composite class for nesting tags inside one another.
 */
public class HTMLComposite extends HTMLConstruct{
	public ArrayList<HTMLConstruct> children = new ArrayList<HTMLConstruct>();
	
	public HTMLComposite(){
		
	}
	
	public String insert(){
		String temp = "";
		for( int i = 0 ; i < children.size() ; i++ ){
			HTMLConstruct c = children.get(i);
			temp += c.insert() + "\n";
		}
		return temp;
	}
	
	public void add( HTMLConstruct c ){
		children.add( c );
	}
	
	public void remove( HTMLConstruct c ){
		children.remove( c );
	}
}