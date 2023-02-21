package caesarcipher;

import java.util.Scanner;

public class Caesarciphe {
	public static String Encrypt(String givenMessage, int positions) {
		String toEncrypt = "" ,result = "";
		for(int i = 0 ; i < givenMessage.length() ; i++)
		{
			if(givenMessage.charAt(i) == ' ') {
				continue;
			}
			else {
				if(Character.isLowerCase(givenMessage.charAt(i))) {
					toEncrypt += Character.toUpperCase(givenMessage.charAt(i));
				}
				else {
					toEncrypt  += givenMessage.charAt(i);
				}
			}
		}
		
		for(int i = 0 ; i  < toEncrypt.length() ; i++)
		{
		   char shiftedLetter = (char)(toEncrypt.charAt(i) + positions);
		   if(shiftedLetter > 'Z')
		   {
			   shiftedLetter = (char)(shiftedLetter + 'A' - 'Z' - 1);
		   }
		   result += shiftedLetter;	
		}
		return result;
	}
	public static String Decrypt(String givenMessage , int positions)
	{
		String result = "";
		for(int i = 0 ; i < givenMessage.length() ; i++)
		{
			char shiftedLetter = (char)(givenMessage.charAt(i) - positions);
			if(shiftedLetter < 'A')
			{
				shiftedLetter = (char)(shiftedLetter - 'A' + 'Z' + 1);
			}
			result += shiftedLetter;
		}
		return result ;
	}
	public static void main(String[] args)
	{
		System.out.println("CAESAR CIPHER");
		
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("Type Your Important Message : ");
		
		String message = sc.nextLine();
		
		System.out.println("Type the key");
		
		int key = sc.nextInt();
		sc.close();
		System.out.println();
		
		System.out.println("Encryptin started...");
		
		String encryptedMessage = Encrypt(message,key);
		
		System.out.println("The encrypted message is : " + encryptedMessage);
		
		System.out.println("Encryption Complete");
		
		System.out.println("Decrypting...");
		String restoredMessage = Decrypt(encryptedMessage , key );
		
		System.out.println("The Decrypted message is : " + restoredMessage);
		System.out.println("Decryption Complete");
	}

}
