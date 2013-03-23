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
