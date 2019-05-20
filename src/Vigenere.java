/**
 * Class Vigenere that encapsulates the Vigenère cipher method to encrypt and decrypt text.
 * 
 * @autor Mahmoud Abdelrahman, Mulhamam Alisali, Nawid Shadab
 * 
 */


public class Vigenere {
	String plainText, cipherText;
	char key;

	public String getPlainText() {
		return plainText;
	}

	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}

	public String getCipherText() {
		return cipherText;
	}

	public void setCipherText(String cipherText) {
		this.cipherText = cipherText;
	}

	public char getKey() {
		return key;
	}

	public void setKey(char key) {
		this.key = Character.toUpperCase(key);
	}
	
	public String analyse()
	{
		char key = getKey(cipherText);
		return decipher(cipherText, key);
	}
	
	/**
	 * In this method we implement the vigenere cipher decryption algorithm.
	 * We go through the text, letter by letter and decrypt it.
	 * @return The text after decryption.
	 */
	public static char getKey(String cipher) {
		HeufigkeitTabelle ht = new HeufigkeitTabelle();
		
		double min = Double.MAX_VALUE;
		char key = 'a';
		double testing = 0;
		
		for(char c = 'a'; c <= 'z'; c++) {
			//System.out.println(decipher(cipher,c)+ "\n");
			testing = ht.rechneDistanz(decipher(cipher,c));
			if(testing < min) {
				min = testing;
				key = c;
			}
		}
		
		return key;
	}
	
	public static String decipher(String cipherText, char key)
	{
		//cipherText = HelpMethods.replaceUmlaut(cipherText);
		cipherText = cipherText.toUpperCase();
		String plainText = "";
		key = Character.toUpperCase(key);
		for(int i = 0, count = 0, length = cipherText.length(); i< length; i++)
		{
			if(Character.isAlphabetic(cipherText.charAt(i)))
			{
				char result = (char) (((cipherText.charAt(i)) - key + 26) % 26 + 65);
				plainText += Character.toString((char) (result));
				count++;
			}
			
		
		}
		return plainText.toLowerCase();
	}
	
	

}
