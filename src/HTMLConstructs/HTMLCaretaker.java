package HTMLConstructs;

import java.util.ArrayList;

/**
 * 
 * @author Matthew Waite
 * This class serves as the Caretaker in the Memento pattern
 */
public class HTMLCaretaker {

	private ArrayList<CollapsedMemento> collapsedMementos;
	private ArrayList<FullTreeMemento> fullTreeMementos;
	
	public HTMLCaretaker(){
		this.collapsedMementos = new ArrayList<CollapsedMemento>();
		this.fullTreeMementos = new ArrayList<FullTreeMemento>();
	}
	
	/**
	 * This method will request that the HTMLTree create a Memento for
	 * the whole tree
	 * 
	 * After receiveing the Memento, it will be added to the corresponding
	 * Arraylist
	 * 
	 * @param c - HTMLConstruct representing the head of the tree
	 * @param cursorPosition - The position of the cursor in the GUI based on 
	 * 						   an offset
	 */
	public void addFullMemento(HTMLConstruct c, int cursorPosition){
		this.fullTreeMementos.add(HTMLTree.createFullMemento(c, cursorPosition));
	}
	
	/**
	 * This method will request that the HTMLTree create a Memento representing
	 * an uncollapsed subtree of the HTML structure
	 * 
	 * When the Memento is received, it will be added to the corresponding
	 * ArrayList
	 * 
	 * @param head - HTMLConstruct representing the head of the tree
	 * @param c - HTMLConstruct representing the subtree to find
	 * @param cursorPosition - The position of the cursor in the GUI based
	 * 						   on an offset
	 */
	public void addSubMemento(HTMLConstruct head, HTMLConstruct c, int cursorPosition){
		this.collapsedMementos.add(HTMLTree.createSubMemento(head, c, cursorPosition));
	}
	
	/**
	 * This method will search through the collapsedMemento ArrayList to try
	 * to match the given subtree to one of the Mementos
	 * 
	 * This maintains the structure of the Memento pattern because only the
	 * Memento itself inspects its contents, and those contents are never
	 * manipulated
	 * 
	 * @param c - HTMLConstruct representing the subtree Memento to match
	 * @return - The Match in Memento form, or null if no match is found
	 */
	public CollapsedMemento findSubMemento(HTMLConstruct c){
		for (int i = 0; i < collapsedMementos.size(); i++){
			if(collapsedMementos.get(i).equals(c)){
				return collapsedMementos.get(i);
			}
		}
		return null;
	}

}
