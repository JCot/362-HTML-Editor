package HTMLConstructs;

import java.util.ArrayList;

public class HTMLCaretaker {

	private ArrayList<CollapsedMemento> collapsedMementos;
	private ArrayList<FullTreeMemento> fullTreeMementos;
	
	public HTMLCaretaker(){
		this.collapsedMementos = new ArrayList<CollapsedMemento>();
		this.fullTreeMementos = new ArrayList<FullTreeMemento>();
	}
	
	public TreeMemento findMemento(HTMLConstruct c){
		return new FullTreeMemento();
	}

}
