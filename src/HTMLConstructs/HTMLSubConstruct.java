/**
 * 
 */
package HTMLConstructs;
import java.util.ArrayList;

/**
 * @author ikeku_000
 *
 */
public class HTMLSubConstruct extends HTMLConstruct{
	ArrayList<HTMLConstruct> list = new ArrayList<HTMLConstruct>();
	
	public String insert(){
		String temp = "";
		for( int i = 0 ; i < list.size() ; i++ ){
			HTMLConstruct c = list.get(i);
			temp += c.insert( c );
		}
		return temp;
	}
	
	public void add( HTMLConstruct c ){
		list.add( c );
	}
	
	public void remove( HTMLConstruct c ){
		list.remove( c );
	}
}