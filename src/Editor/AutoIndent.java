package Editor;

/**
 * This class will handle auto-indentation.
 */


/**
 * @author Justin Cotner, jdc9622
 *
 */
public class AutoIndent {

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
	public static String indent(String prevLine, int indentSize){
		String indentLen = "";
		String temp;
		String oneLevel = "";
		int numWhiteSpace = 0;
		char tempChar;
		
		for(int i = 1; i <= indentSize; i++){
			oneLevel += " ";
		}

		for(int i = 0; i <= prevLine.length() - 1; i++){

			tempChar = prevLine.charAt(i);
			temp = Character.toString(tempChar);

			if(temp.matches("[\\S]")){
				break;
			}

			else{
				if(temp.equals("\t")){
					indentLen += "\t";
				}
				else{
					indentLen += " ";
				}

				numWhiteSpace += 1;
			}
		}

		if(prevLine.trim().matches("<(\"[^\"]*\"|'[^']*'|[^'\">])*>")){

			if(!prevLine.contains("/")){
				indentLen += oneLevel;
			}
			
			else{
				indentLen = "";
				
				for(int j = 1; j <= numWhiteSpace - indentSize; j++){
					indentLen += " ";
				}
			}
		}
				
		return indentLen;
	}

}
