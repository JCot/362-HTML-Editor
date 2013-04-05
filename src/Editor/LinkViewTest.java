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
			"https://reddit.com aosudiosjad aosijd www.aol.com";
	private LinkView view = new LinkView();
	
	public void testreturnOrderOfAppearance(){
		view.findLinks(testString);
		String temp = view.returnOrderofAppearance();
		assertEquals("http://www.google.com\nhttps://reddit.com\n" +
				"www.aol.com\n", temp);
	}

}
