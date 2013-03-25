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
        message = message.toLowerCase();
        for (int i = 0; i < message.length(); i++) {
            messageChar = shiftChar(message.charAt(i));
            keyChar = shiftChar(key.charAt(i % key.length()));
            messageChar = (char) ((keyChar + messageChar) % 29);
            messageChar = reShiftChar(messageChar);
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
        String decryptedMessage = "";
        cipher = cipher.toLowerCase();
        for (int i = 0; i < cipher.length(); i++) {
            cipherChar = shiftChar(cipher.charAt(i));
            keyChar = shiftChar(key.charAt(i % key.length()));
            cipherChar = (char) ((cipherChar - keyChar));
            cipherChar = fixOverflow(cipherChar);
            cipherChar = reShiftChar(cipherChar);
            decryptedMessage += cipherChar;
        }
        return decryptedMessage;
    }
    
    /*--- Below are the helper functions ---*/
    
    private char fixOverflow(char n){
        if(n < 50000){
            return n;
        } else{
            n += 29;
        }
        return n;
    }
    
    private String sanitzeString(String s) {
        Scanner scan = new Scanner(s);
        String sanitzedString = "", temp = "";
        while (scan.hasNext()) {
            temp = scan.next();
            temp = temp.replaceAll("[^A-Za-zåäöÅÄÖ]", "");
            sanitzedString += temp;
        }
        scan.close();
        return sanitzedString;
    }

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

    private char reShiftChar(char c) {
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
