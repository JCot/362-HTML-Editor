import java.util.*;
import java.io.*;

/**
 * @author Justin Cotner jdc9622
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
		return file.getName();
	}
	
	public boolean open(){ //make private later?
		BufferedReader reader;
		String line = null;
		
		try{
			reader = new BufferedReader(new FileReader(file));
			
			while((line = reader.readLine()) != null){
				text = text + line + "\n";
			}
			
			text = text.substring(0, text.length() - 1);
			
			return true;
		}
		
		catch(IOException e){
			return false;
		}
	}
	
	public boolean save(){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write(text);
			
			return true;
		}
		
		catch(IOException e){
			return false;
		}
	}
	
	public boolean saveAs(String name){
		file = new File(name);
		fileName = file.getName();
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write(text);
			
			return true;
		}
		
		catch(IOException e){
			return false;
		}
	}
	
	public boolean close(){
		
		return false;
	}

}
