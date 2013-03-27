package Editor;

/**
 * This class will handle auto-indentation.
 */


/**
 * @author Justin Cotner, jdc9622
 *
 */
public class AutoIndent {

	public static String indent(String prevLine, int indentSize){
		String indentLen = "";
		String temp;
		int numWhiteSpace = 0;
		char tempChar;

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
				for(int i = 1; i <= indentSize; i++){
					indentLen += " ";
				}
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