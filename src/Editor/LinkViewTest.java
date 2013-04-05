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
	
	private String testString = "http://www.google.com asdasod aosd " +
			"www.aol.com aosudiosjad aosijd https://reddit.com";
	private LinkView view = new LinkView();
	
	public void testreturnOrderOfAppearance(){
		view.findLinks(testString);
		String temp = view.returnOrderofAppearance();
		assertEquals("http://www.google.com\nwww.aol.com\n" +
				"https://reddit.com\n", temp);
	}
	
	public void testReturnOrdered(){
		view.findLinks(testString);
		String temp = view.returnOrdered();
		assertEquals("http://www.google.com\nhttps://reddit.com\nwww.aol.com\n",
				temp);
	}

}
