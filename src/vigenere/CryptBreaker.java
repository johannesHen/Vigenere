package vigenere;

import java.util.ArrayList;

import java.util.regex.*;

/**
 * Class for decryting a cipher encrypted with the Vigenere cipher.
 * @author JohannesH
 *
 */
public class CryptBreaker {
	public static String breakCipher(String cipher){
		return "";
	}
	
	/**
	 * Calculates the length of the key by finding the distances between the closest identical substrings
	 *  in a string finding the greatest common divisor for the distances.
	
	 * @param cipher the string that's operated on
	 * @return the probable length of the key
	 */
	
	/*
	 * Psudo-algorithm:
	 * 1. Chose the best substring(Criteria? Number of occurrences? Length?).
	 * 2. Collect all the distances.
	 * 3. Find the greatest common divisor for the distances between the matches.
	 */
	private int kasiski(String cipher){
		return 0;
	}
	
	private int mostRepeated(String s){
		Pattern p = Pattern.compile("hello");
	    Matcher m = p.matcher(s);
	    int count = 0;
	    while (m.find()){
	    	count +=1;
	    }
	    System.out.println(count);
	    return count;
	}
}
