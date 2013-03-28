package Editor;

import java.util.ArrayList;
import java.io.*;
import GUI.EditorGUI;
import javax.swing.*;


public class HtmlEditor {
	
	private static ArrayList<Document> docs = new ArrayList<Document>();
	
	/**
	 * Creates a document object for the given filename and then calls
	 * open on that document object
	 * @param file
	 * @return String - returns the text found in the file to the GUI
	 */
	public static String openFile(File file){
		Document tempDoc = new Document(file);
		tempDoc.open();
		
		docs.add(tempDoc);
		
		return tempDoc.getText();
	}
	
    /**
	 * Creates a temporary Document object from the specified file
	 * and checks to see whether it is made in well-formed html
	 * @param file
	 * @return boolean - true if well-formed, false if not
	 */
	public static boolean wellFormedCheck(File file){
		Document tempDoc = new Document(file);
		tempDoc.open();
		
		if(!tempDoc.checker.wellFormedCheck(tempDoc.getText())){
			return false;
		}
		
		return true;
	}
	
    /**
	 * Iterates through the document array to find the specified File object
	 * @param file
	 * @return - true if file exists, false if not
	 */
	public static boolean fileExists(File file){
		for(int i = 0; i < docs.size(); i++){
			if(docs.get(i).getFileName().equals(file.getName())){
				return true;
			}
		}
		return false;
	}
    
	/**
	 * Takes in a file to save and the name to save as
	 * It will return a warning message if the file is not well-formed html
	 * @param file
	 * @param text - The name to save the file as
	 * @return String - returns either an empty string or the warning message
	 */
	public static String save(File file, String text){
		Document tempDoc = null;
		
		for(int i = 0; i < docs.size(); i++){
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
	
    /**
	 * Takes in a file object and the name of the file to save as,
	 * and proceeds to save the file
	 * @param file
	 * @param text
	 * @return boolean - true if saved, false if not
	 */
	public static boolean saveIllFormed(File file, String text){
		Document tempDoc = null;
		
		for(int i = 0; i < docs.size(); i++){
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
	
    /**
	 * Takes in a file object and the filename to save as
	 * It will save the file if well-formed, and return a warning if not
	 * @param file
	 * @param text
	 * @return String - returns either an empty string or the warning message
	 */
	public static String saveAs(File file, String text){
		
		Document tempDoc = null;
		
		for(int i = 0; i <= docs.size(); i++){
			if(docs.get(i).getFileName().equals("Untitled")){
				tempDoc = docs.get(i);
				break;
			}
		}
		
		if(tempDoc != null && tempDoc.checker.wellFormedCheck(text)){
			tempDoc.saveAs(file, text);
			return "";
		}
		
		else{
			return "Warning: This document is not well formed.";
		}
	}
	
    /**
	 * Takes in a file object and the filename to save as
	 * @param file
	 * @param text
	 * @return boolean - returns true if saved, and false if not
	 */
	public static boolean saveAsIllFormed(File file, String text){
		Document tempDoc = null;
		
		for(int i = 0; i < docs.size(); i++){
			if(docs.get(i).getFileName().equals("Untitled")){
				tempDoc = docs.get(i);
				break;
			}
		}
		
		if(tempDoc != null){
			tempDoc.saveAs(file, text);
			return true;
		}
		
		else{
			return false;
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
			
		} 
		
		else
		{
			/* An ArrayList of all of the valid filenames given on the command line */
			ArrayList<String> validFiles = new ArrayList<String>();
			
			for(int i = 0; i < args.length; i++)
			{
				String filename = args[i];
				String[] splitFilename = filename.split("\\.");

				/*
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
		JFrame frame = new EditorGUI();
		
	}
	
}
