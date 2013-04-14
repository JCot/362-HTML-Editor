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
	
	/**
	 * This method, defined in the Memento Pattern,
	 * will generate a new Memento of the entire tree.
	 * 
	 * This method will only be called by HTMLCaretaker when the system
	 * requests a Memento for the Undo command
	 * 
	 * @return FullTreeMemento
	 */
 	public FullTreeMemento createMemento(){
		FullTreeMemento m = new FullTreeMemento();
		m.head = this.head;
		return m;
	}
	
 	/**
 	 * This method will restore the system to a previous state
 	 * after the undo command is selected
 	 * 
 	 * It will restore the state of the entire tree structure from a copy
 	 * stored in the Memento
 	 * 
 	 * @param m - A FullTreeMemento which represents the state
 	 * of the editor to be restored
 	 */
	public void SetMemento( FullTreeMemento m ){
		this.head = m.head;
	}
	
	/**
	 * This method will create a Memento of a given subtree so 
	 * that Outline mode can be supported
	 * 
	 * If the given construct and its sub-components match a part 
	 * of the tree stored by the system, then the Memento will be 
	 * created from the match
	 * 
	 * @param c - HTMLConstruct
	 * @return - CollapsedMemento
	 */
	public CollapsedMemento createMemento( HTMLConstruct c ){
		CollapsedMemento m = new CollapsedMemento();
		while(! head.equals( c ) ){}
		
		m.head = c;
		m.parent = parent;
		return m;
	}
	
	/**
	 * This method will restore the state of the system to a previous state
	 * when uncollapsing items in Outline mode
	 * 
	 * It will restore the state of the system from the old copy of the subtree
	 * saved in the Memento 
	 * 
	 * @param m - CollapsedMemento
	 */
	public void setMemento( CollapsedMemento m ){
		c.parent = m.parent;
	}

}
