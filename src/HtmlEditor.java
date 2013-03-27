import java.util.ArrayList;

import java.io.*;

import GUI.EditorGUI;
import javax.swing.*;


public class HtmlEditor {
	private static ArrayList<Document> docs = new ArrayList<Document>();
	
	public static String openFile(File file){
		Document tempDoc = new Document(file);
		tempDoc.open();
		
		if(!tempDoc.checker.wellFormedCheck(tempDoc.getText())){
			//Put some sort of error message here
		}
		
		docs.add(tempDoc);
		
		return tempDoc.getText();
	}
	
	public void newFile(){
		Document tempDoc = new Document();
		docs.add(tempDoc);
	}
	
	public String save(File file, String text){
		Document tempDoc = null;
		
		for(int i = 0; i <= docs.size(); i++){
			if(docs.get(i).getFileName().equals(file.getName())){
				tempDoc = docs.get(i);
				break;
			}
		}
		
		if(tempDoc != null && tempDoc.checker.wellFormedCheck(text)){
			tempDoc.save(text);
			return "";
		}
		
		else{
			return "Warning: This document is not well formed.";
		}
		
	}
	
	public boolean saveIllFormed(File file, String text){
		Document tempDoc = null;
		
		for(int i = 0; i <= docs.size(); i++){
			if(docs.get(i).getFileName().equals(file.getName())){
				tempDoc = docs.get(i);
				break;
			}
		}
		
		if(tempDoc != null){
			tempDoc.save(text);
			return true;
		}
		
		else{
			return false;
		}
	}
	
	public String saveAs(String fileName, String text){
		
		Document tempDoc = null;
		
		for(int i = 0; i <= docs.size(); i++){
			if(docs.get(i).getFileName().equals("Untitled")){
				tempDoc = docs.get(i);
				break;
			}
		}
		
		if(tempDoc != null && tempDoc.checker.wellFormedCheck(text)){
			tempDoc.saveAs(fileName, text);
			return "";
		}
		
		else{
			return "Warning: This document is not well formed.";
		}
	}

	/**
	 * @param args[String]
	 * The main class will take in file names from the command line and check
	 * to see if they have the right file extensions, and then passes them on
	 * to the main controller
	 */
	public static void main(String[] args) {
		if (args.length == 0 )
		{
			//If no arguments are given on the command line, then the GUI
			//will be booted directly with no text area active
			System.out.println("No arguments given: booting into blank GUI");
			JFrame frame = new EditorGUI();
			
		} 
		else
		{
			/** An ArrayList of all of the valid filenames given on the command line */
			ArrayList<String> validFiles = new ArrayList<String>();
			
			for(int i = 0; i < args.length; i++)
			{
				String filename = args[i];
				String[] splitFilename = filename.split("\\.");

				/** 
				 * If the last part of the filename is txt or html, add 
				 * it to the valid list of files
				 */
				if(splitFilename[splitFilename.length - 1].equals("html")
					|| splitFilename[splitFilename.length - 1].equals("txt"))
				{
					//System.out.println("Good Extension");
					validFiles.add(filename);
				} 
				else 
				{
					System.err.println("USAGE: " + splitFilename[splitFilename.length - 1] + 
							" is not a supported file extension.\nPlease use either .txt or .html");
					System.exit(0);
				}
			}
			for(String e: validFiles)
			{
				File file = new File(e);
				openFile(file);
				System.out.println(e);
			}
		}
		
	}
	
}
