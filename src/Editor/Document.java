package Editor;

/**
 * This class will represent an HTML document.  It contains the actual file object, the text from the file, and the methods
 * required to open, save, and edit a document.  Some operations will be passed off to other classes
 */

import java.io.*;

/**
 * @author Justin Cotner, jdc9622
 *
 */
public class Document {
	private String fileName;
	private String text = "";
	private File file;
	private WellFormed checker = new WellFormed();
	
	/*
	 * Constructor for opening an existing HTML document.
	 */
	public Document(File file){
		this.file = file;
		this.fileName = file.getName();
		open();
	}
	
	/*
	 * Constructor for creating a new HTML document.
	 */
	public Document(){
		fileName = "Untitled";
	}
	
	public String getText(){
		return text;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public String getFileName(){
		return fileName;
	}
	
	/**
	 * Takes a string and makes sure that it is
	 * well formed HTML. Handles this by passing
	 * it off to the WellFormed class.
	 * 
	 * @param String text - the text to be checked
	 * @return boolean false if the text is not well
	 * 		   formed and true if it is
	 */
	public boolean wellFormedCheck(String text){
		return checker.wellFormedCheck(text);
	}
	
	/**
	 * Reads through the file and returns the contents
	 * of the file as a String.
	 * 
	 * @return String fileContents - the contents of the file
	 */
	public String readFile() throws IOException{
		String fileContents = "";
		BufferedReader reader;
		String line = null;
		
		reader = new BufferedReader(new FileReader(file));
		
		while((line = reader.readLine()) != null){
			fileContents = fileContents + line + System.getProperty("line.separator");
		}
		
		reader.close();
		
		return fileContents;
	}
	
	/**
	 * Attempts to open the file a Document class is
	 * instantiated with. Sets text to the contents
	 * of the file returned by readFile()
	 * 
	 * @return boolean false if trying to open the file
	 * throws an IOException and true if the file was
	 * opened correctly
	 */
	public boolean open(){
		
		try{
			text = readFile();
			
			return true;
		}
		
		catch(IOException e){
			return false;
		}
	}
	
	/**
	 * Updates the text stored in the Document class and
	 * saves it to a file. The wellformed check is performed
	 * in the Editor class before this method is called.
	 * 
	 * @param String text - the text that is to be
	 * saved to the file
	 * @return boolean - false if writing to the file
	 * throws an IOException and true otherwise
	 */
	public boolean save(String text){
		this.text = text;
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			writer.write(text);

			writer.close();

			return true;
		}
		
		catch(IOException e){
			return false;
		}
	}
	
	/**
	 * Method for saving if a Document instance was
	 * created without specifying a file. Sets the
	 * Documents file variable to file for future saves.
	 * Also updates Document's text variable and saves
	 * it to the file given.
	 * 
	 * @param File file - the file object to save the
	 * text to
	 * @param  String text - the text to be saved
	 * @return boolean - false if writing to the file
	 * throws and IOException and true otherwise
	 */
	public boolean saveAs(File file, String text){
		this.file = file;
		this.fileName = file.getName();
		this.text = text;
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write(text);
			
			writer.close();
			
			return true;
		}
		
		catch(IOException e){
			return false;
		}
	}

}
