import java.util.ArrayList;
import GUI.EditorGUI;
import javax.swing.*;

public class HtmlEditor {

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
				System.out.println(e);
			}
		}
		
	}
	
}
