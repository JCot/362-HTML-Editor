package Editor;

/**
 * This class will handle auto-indentation.
 */


/**
 * @author Justin Cotner, jdc9622
 *
 */
public class AutoIndent {

	public static int indentSize;
	
	/** String representing the current indentation to insert for Auto-Indent */
	public static String oneLevel;
	
	/** Boolean value denoting user's preference for auto-wrap */
	public static boolean isOn = false;
	
	public static String indent = "";
	
	/**
	 * Provides the indentation for the current line by
	 * taking the previous line and counting the leading white
	 * spaces. Returns a string of that many white spaces
	 * if the previous line does not contain a tag. If the
	 * previous line contains a tag appends a number of white
	 * spaces equal to the indentSize to the returned String.
	 * If the previous line is an end tag removes a number of
	 * white spaces equal to the indentSize
	 * 
	 * @param String prevLine - the previous line
	 * to check for the indentation level.
	 * @param int indentSize - the number of spaces in a standard
	 * indent level
	 * @return String - a string of white spaces to insert
	 * on a line for the proper indentation level.
	 */
	public static String indent(String text, int line){
		String temp;
		oneLevel = "";
		indent = "";
		int numWhiteSpace = 0;
		char tempChar;
		String[] tempText = text.split("\n");
		String prevLine;

		if(tempText.length != 0){
			if(line == 0){
				prevLine = tempText[0];
			}

			else{
				prevLine = tempText[line - 1];
			}

			for(int i = 1; i <= indentSize; i++){
				oneLevel += " ";
			}

			for(int i = 0; i <= prevLine.length() - 1; i++){

				tempChar = prevLine.charAt(i);
				temp = Character.toString(tempChar);

				if(temp.matches("\\S")){
					break;
				}

				else{
					indent += " ";

					numWhiteSpace += 1;
				}
			}

			if(prevLine.trim().matches("<(\"[^\"]*\"|'[^']*'|[^'\">])*>")){

				if(!prevLine.contains("/")){
					indent += oneLevel;
				}
			}

		}
			
				
		return indent;
	}
	
	/**
	 * Method for indenting tags.  Takes in a String that is the
	 * Html Tag set to be indented.  Splits it into individual
	 * components and performs indent on each one.  Slightly different
	 * than indent because end tags need to be moved out to the proper
	 * level.
	 * 
	 * @param String text - the Html tag set to be indented
	 * @return String temp - the properly indented Html
	 * 						 tag set
	 */
	public static String indentTags(String text){
		String temp = "";
		String[] lines = text.split("\n");
		
		System.out.println("Shit: " + indent.length());
		System.out.println(lines[0]);
		
		for(int i = 1; i < lines.length; i++){
			String tempTwo = lines[i - 1] + "\n" + lines[i];
			lines[i] = AutoIndent.indent(tempTwo, 1) + lines[i];
			
			System.out.println(indent.length());
			
			if(lines[i].contains("/") && lines[i].contains(AutoIndent.oneLevel)){
				System.out.println(i + " Fuck");
				lines[i] = lines[i].substring(AutoIndent.indentSize);
			}
			
			temp += lines[i] + "\n";
		}
		
		temp = lines[0].trim() + "\n" + temp;
		
		return temp;
	}

}
