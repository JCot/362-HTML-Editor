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
	
	public boolean wellFormedCheck(String text){
		return checker.wellFormedCheck(text);
	}
	
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
	
	public boolean open(){
		
		try{
			text = readFile();
			
			return true;
		}
		
		catch(IOException e){
			return false;
		}
	}
	
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
