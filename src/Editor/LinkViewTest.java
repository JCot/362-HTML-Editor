/**
 * 
 */
package Editor;

import junit.framework.TestCase;

/**
 * @author Justin
 *
 */
public class LinkViewTest extends TestCase{
	
	private String testString = "\"http://www.google.com\" asdasod aosd " +
			"\"www.aol.com\" aosudiosjad aosijd \"https://reddit.com\"";
	private LinkView view = new LinkView();
	
	public void testreturnOrderOfAppearance(){
		String testString = "\"http://www.google.com\" asdasod aosd " +
				"\"www.aol.com\" aosudiosjad aosijd \"https://reddit.com\"";
		view.findLinks(testString);
		String temp = view.returnOrderofAppearance();
		assertEquals("http://www.google.com\nwww.aol.com\n" +
				"https://reddit.com\n", temp);
	}
	
	public void testReturnOrdered(){
		String testString = "\"http://www.google.com\" asdasod aosd " +
				"\"www.aol.com\" aosudiosjad aosijd \"https://reddit.com\"";
		view.findLinks(testString);
		String temp = view.returnOrdered();
		assertEquals("http://www.google.com: 1\nhttps://reddit.com: 1" +
				"\nwww.aol.com: 1\n",
				temp);
	}
	
	public void testDuplicatesOrdered(){
		testString += " \"www.aol.com\"";
		view.findLinks(testString);
		String temp = view.returnOrdered();
		assertEquals("http://www.google.com: 1\nhttps://reddit.com: 1" +
				"\nwww.aol.com: 2\n", temp);
	}

}
