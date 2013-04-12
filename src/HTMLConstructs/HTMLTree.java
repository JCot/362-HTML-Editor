/**
 * 
 */
package HTMLConstructs;

/**
 * @author Isaac Kunkel
 * @author Matthew Waite
 * This class holds and manipulates the tag tree structure for Outline Mode.
 */
public class HTMLTree {
	HTMLConstruct head;
	
	public HTMLTree( HTMLConstruct head ){
		this.head = head;
	}
	
	public FullTreeMemento createMemento(){
		FullTreeMemento m = new FullTreeMemento();
		m.head = this.head;
		return m;
	}
	
	public void SetMemento( FullTreeMemento m ){
		this.head = m.head;
	}
	
	public CollapsedMemento createMemento( HTMLConstruct c ){
		CollapsedMemento m = new CollapsedMemento();
		while(! head.equals( c ) ){}
		
		m.head = c;
		m.parent = parent;
		return m;
	}
	
	public void setMemento( CollapsedMemento m ){
		c.parent = m.parent;
	}

}
