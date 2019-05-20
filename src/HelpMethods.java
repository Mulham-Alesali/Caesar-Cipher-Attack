/**
 * Class HelpMethods that contains Helper methods like replaceUmlaut() and normalize().
 * 
 * @autor Mahmoud Abdelrahman, Mulhamam Alisali, Nawid Shadab
 * 
 */


public class HelpMethods {
	
	/**
	 * In this method we take the original text and ignore all white spaces
	 * and other special characters.
	 * @param text: the original text
	 * @return modified text after taking away all special characters
	 * and white spaces.
	 */
	public static String normalize(String text)
	{
		StringBuilder result = new StringBuilder("");
		for(int i = 0, length = text.length(); i< length; i++)
		{
			if(Character.isAlphabetic(text.charAt(i)))
			{
				result.append( text.charAt(i));
			}
		}
		return result.toString().toLowerCase();
	}
}
