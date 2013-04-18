package HTMLConstructs;

/**
 * 
 * @author Matthew Waite
 * This is a abstract class which represents the basic interface of the 
 * Memento of an HTMLTree
 */
public abstract class TreeMemento {
	
	private HTMLConstruct head;
	private int cursorOffset;
	
	public HTMLConstruct getHead(){
		return this.head;
	}
	
	public int getCursorPosition(){
		return this.cursorOffset;
	}
	
	public void setHead(HTMLConstruct head){
		this.head = head;
	}
	
	public void setCursorPosition(int position){
		this.cursorOffset = position;
	}
}
