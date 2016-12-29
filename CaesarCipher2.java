
import edu.duke.*;

public class CaesarCipher2 {
	 public String encryptTwoKeys(String input, int key1, int key2) {
	        //Make a StringBuilder with message (encrypted)
	        StringBuilder encrypted = new StringBuilder(input);
	        //Write down the alphabet
	        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
	        //Compute the shifted alphabet for key 1
	        String shiftedAlphabet = alphabet.substring(key1)+
	        alphabet.substring(0,key1);
	        String shiftedLowerAlphabet = lowerAlphabet.substring(key1) + lowerAlphabet.substring(0, key1);
	        //Compute the shifted alphabet for key 2
	        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
	        String shiftedLowerAlphabet2 = lowerAlphabet.substring(key2) + lowerAlphabet.substring(0, key2);
	        //Count from 0 to < length of encrypted, (call it i)
	        for(int i = 0; i < encrypted.length(); i+= 2) {
	            //Look at the ith character of encrypted (call it currChar)
	            char currChar = encrypted.charAt(i);
	            //Find the index of currChar in the alphabet (call it idx)
	            int idx = alphabet.indexOf(currChar);
	            int idxLower = lowerAlphabet.indexOf(currChar);
	            //If currChar is in the alphabet and UpperCase
	            
	            	if(isUpperCase(currChar) == true){
		            	if(idx != -1){
		                //Get the idxth character of shiftedAlphabet (newChar)
		            		char newChar = shiftedAlphabet.charAt(idx);
		                //Replace the ith character of encrypted with newChar
		            		encrypted.setCharAt(i, newChar);
		            	}
		            } // if currChar is in lowerCase alphabet
		            if(isLowerCase(currChar) == true){
		            	if(idxLower != -1){
		            		char newLowerChar = shiftedLowerAlphabet.charAt(idxLower);
		            		encrypted.setCharAt(i, newLowerChar);
		            	}
		            }
	            
	        }
	        // for loop starting at 1, plus 2
	        for(int i = 1; i < encrypted.length(); i+= 2) {
	            //Look at the ith character of encrypted (call it currChar)
	            char currChar = encrypted.charAt(i);
	            //Find the index of currChar in the alphabet (call it idx)
	            int idx = alphabet.indexOf(currChar);
	            int idxLower = lowerAlphabet.indexOf(currChar);
	            //If currChar is in the alphabet and UpperCase
	    
	            if(isUpperCase(currChar) == true){
	            	if(idx != -1){
	                //Get the idxth character of shiftedAlphabet (newChar)
	            		char newChar = shiftedAlphabet2.charAt(idx);
	                //Replace the ith character of encrypted with newChar
	            		encrypted.setCharAt(i, newChar);
	            	}
	            } // if currChar is in lowerCase alphabet
	            if(isLowerCase(currChar) == true){
	            	if(idxLower != -1){
	            		char newLowerChar = shiftedLowerAlphabet2.charAt(idxLower);
	            		encrypted.setCharAt(i, newLowerChar);
	            	}
	            }
	            //Otherwise: do nothing
	        }
	        //Your answer is the String inside of encrypted
	        return encrypted.toString();
	    }
	    private static boolean isLowerCase(char Chr) {
		// checks to see if char is upper or lower case
	    	//create string of lower case alphabet
	    	String lowerAlpha = "abcdefghijklmnopqrstuvwxyz";	    	
	    	for (int i = 0; i < lowerAlpha.length(); i++) {
	    		if (Chr == lowerAlpha.charAt(i)) {
	    			return true;
	    		}
	    	}
		return false;
	    }
	    private static boolean isUpperCase(char Chr) {
			// checks to see if char is upper or lower case
		    	//create string of lower case alphabet
		    	String upperAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";	    	
		    	for (int i = 0; i < upperAlpha.length(); i++) {
		    		if (Chr == upperAlpha.charAt(i)) {
		    			return true;
		    		}
		    	}
			return false;
		    }
	    
		public void testCaesar2() {
	        int key1 = 21;
	        int key2 = 8;
	        FileResource fr = new FileResource();
	        String message = fr.asString();
	        String encrypted = encryptTwoKeys(message, key1, key2);
	        System.out.println(encrypted);
	        String decrypted = encryptTwoKeys(encrypted, 26-key1, 26-key2);
	        System.out.println(decrypted);
	    } 
		/*public void main(String[] args) {
			testCaesar2();
		}*/
}
