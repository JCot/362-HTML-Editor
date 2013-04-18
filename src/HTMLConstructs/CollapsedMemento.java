package HTMLConstructs;

/**
 * 
 * @author Matthew Waite
 * This is an extension of the TreeMemento class which represents a
 * Memento of a subtree in the HTMLTree
 */
public class CollapsedMemento extends TreeMemento {

	public CollapsedMemento(HTMLConstruct head, int cursorPosition){
		super.setHead(head);
		super.setCursorPosition(cursorPosition);
	}
	
	/**
	 * Checks to see whether the Memento's contents match a given subtree
	 * to determine whether it is the Memento to be restored
	 * 
	 * @param c - The subtree to try to match
	 * @return - true if a match was found, false if not
	 */
	public boolean equals(HTMLConstruct c){
		if (c.equals(super.getHead())){
			return true;
		} else {
			return false;
		}
	}
	
}
