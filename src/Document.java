/**
 * This class will represent an HTML document.  It contains the actual file object, the text from the file, and the methods
 * required to open, save, and edit a document.  Some operations will be passed off to other classes
 */

import java.util.*;
import java.io.*;

/**
 * @author Justin Cotner, jdc9622
 *
 */
public class Document {
	private String fileName;
	private String text = "";
	private File file;
	private AutoIndent indenter = new AutoIndent();
	private WellFormed checker = new WellFormed();
	
	public Document(File file){
		this.file = file;
		this.fileName = file.getName();
		open();
	}
	
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
	
	public String autoIndent(String prevLine){
		return indenter.indent(prevLine);
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
	
	public boolean open(){ //make private later?
		
		try{
			text = readFile();
			
			return true;
		}
		
		catch(IOException e){
			return false;
		}
	}
	
	public boolean save() throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		writer.write(text);
		
		writer.close();
			
		return true;
	}
	
	public boolean saveAs(String name){
		file = new File(name);
		fileName = file.getName();
		
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
