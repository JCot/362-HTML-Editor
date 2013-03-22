import junit.framework.TestCase;

import java.io.*;


public class DocumentTest extends TestCase {
	
	Document doc;

	public void setUp() throws Exception {
		File file = new File("Test.txt");
		doc = new Document(file);
	}
	
	public void testGetFileName(){
		String name = doc.getFileName();
		assertEquals("Test.txt", name);
	}

	public void testGetText() {
		String text = doc.getText();
		assertEquals("Text goes here" + "\n" + "I am a file" + "\n" + "Yay", text);
	}

}
