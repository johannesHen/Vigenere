package vigenere;

import java.util.Scanner;

/**
 * Class for handling encryption and decryption of text strings. It uses the vigenere encryption algorithm.
 * @author JohannesH
 */
public class CryptHandler {

    public CryptHandler() {  
    }

    /**
     * Encrypts a text string 
     * @param message the string the be encrypted
     * @param key the key for the encryption
     * @return the encrypted message
     */
    public String encrypt(String message, String key) {
        message = sanitzeString(message);
        System.out.println("Sanitezed string: " + message);
        char messageChar, keyChar;
        String encryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            messageChar = shiftChar(message.charAt(i));
            keyChar = shiftChar(key.charAt(i % key.length()));
            messageChar = (char) ((keyChar + messageChar) % 29);
            messageChar = unshiftChar(messageChar);
            encryptedMessage += messageChar;
        }
        return encryptedMessage;
    }

    /**
     * Decrypts a string
     * @param cipher the cipher to be decrypted
     * @param key the key for the decryption
     * @return The original string, if the key is correct of course.
     */
    public String decrypt(String cipher,String key){
        char cipherChar, keyChar;
        cipher = sanitzeString(cipher);
        String decryptedMessage = "";
        cipher = cipher.toLowerCase();
        for (int i = 0; i < cipher.length(); i++) {
            cipherChar = shiftChar(cipher.charAt(i));
            keyChar = shiftChar(key.charAt(i % key.length()));
            cipherChar = (char) ((29 + cipherChar - keyChar) %  29);
            cipherChar = unshiftChar(cipherChar);
            decryptedMessage += cipherChar;
        }
        return decryptedMessage;
    }
    
    /**
     * Prunes all characters not in the alphabet {A-Öa-ö} from a string and changes it to all lower case.
     * @param s the string to be sanitized.
     * @return The string s, sanitized
     */
    public String sanitzeString(String s) {
        s = s.replaceAll("[^A-Za-zåäöÅÄÖ]", "");
        return s.toLowerCase();
    }
    
    
    /*--- Below are the helper functions ---*/
   
    //Assigns characters a,b,c...å,ä,ö the values 1,2,3...,26,28,29.
    private char shiftChar(char c) {
        if (96 < c && c < 123) {
            c -= 97;
        } else if (c == 229) {
            c = 26;
        } else if (c == 228) {
            c = 27;
        } else if (c == 246) {
            c = 28;
        }
        return c;
    }
    
    //Undoes the assignment in shiftChar and gives the characters back their UTF-8 values. 
    private char unshiftChar(char c) {
        if (0 <= c && c <= 25) {
            c += 97;
        } else if (c == 26) {
            c = 229;
        } else if (c == 27) {
            c = 228;
        } else if (c == 28) {
            c = 246;
        }
        return c;
    }
}
