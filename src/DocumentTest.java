import junit.framework.TestCase;

import java.io.*;


public class DocumentTest extends TestCase {
	
	public void testGetFileName(){
		File file = new File("Test1.txt");
		Document doc = new Document(file);
		String name = doc.getFileName();
		assertEquals("Test1.txt", name);
	}

	public void testGetText() {
		File file = new File("Test1.txt");
		Document doc = new Document(file);
		String text = doc.getText();
		assertEquals("Text goes here" + "\n" + "I am a file" + "\n" + "Yay" + "\n", text);
	}
	
	public void testSave() throws IOException{
		File file = new File("Test2.txt");
		Document doc = new Document(file);
		doc.setText(doc.getText() + "\n" + "I can write to a file");
		System.out.println(doc.getText());
		doc.save();
	}

}
