package HTMLConstructs;

/**
 * 
 * @author Matthew Waite
 * an extension of the TreeMemento class which represents a Memento of
 * the full tree
 */
public class FullTreeMemento extends TreeMemento {

	public FullTreeMemento(HTMLConstruct head, int cursorPosition){
		super.setHead(head);
		super.setCursorPosition(cursorPosition);
	}
	
}
