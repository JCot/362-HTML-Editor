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
	
	public static String indent(int indentLength){
		String temp = "";
		for(int i = 1; i <= indentLength; i++){
			temp = temp + " ";
		}
		return temp;
	}
	
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
		String indent = "";
		int numWhiteSpace = 0;
		char tempChar;
		String[] tempText = text.split("\n");
		String prevLine = tempText[line - 1];
		
		for(int i = 1; i <= indentSize; i++){
			oneLevel += " ";
		}

		for(int i = 0; i <= prevLine.length() - 1; i++){
			System.out.println(i);

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
		
		System.out.println(prevLine);
		System.out.println(oneLevel + "b");
		System.out.println(indent + "a");

		if(prevLine.trim().matches("<(\"[^\"]*\"|'[^']*'|[^'\">])*>")){
			System.out.println("Hi");

			if(!prevLine.contains("/")){
				indent += oneLevel;
			}
			
			else{
				indent = "";
				
				for(int j = 1; j <= numWhiteSpace - indentSize; j++){
					indent += " ";
				}
			}
		}
				
		return indent;
	}

}
