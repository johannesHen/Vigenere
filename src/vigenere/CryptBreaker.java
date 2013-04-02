package vigenere;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.regex.*;

/**
 * Class for decryting a cipher encrypted with the Vigenere cipher.
 * 
 * @author JohannesH
 * 
 */
public class CryptBreaker {
	public static String breakCipher(String cipher) {
		return "";
	}

	/**
	 * Calculates the length of the key by finding the distances between the
	 * closest identical substrings in a string finding the greatest common
	 * divisor for the distances.
	 * 
	 * @param cipher
	 *            the string that's operated on.
	 * @return the probable length of the key.
	 */

	/*
	 * Psudo-algorithm: 1. Chose the best substring(Criteria? Number of
	 * occurrences? Length?). 2. Collect all the distances. 3. Find the greatest
	 * common divisor for the distances between the matches.
	 */
	private int kasiski(String cipher) {
		return 0;
	}

	public static int mostRepeated(String cipher) {
		String s = "hejdejlefhejnejhejdd";
		HashMap<String, Integer> repetedWords = new HashMap<String, Integer>();
		boolean existMatch = false;
		while (s.length() >= 3) {
			String subString = s.substring(0, 3);
			String sEnd = s.substring(3);
			for (int i = 3; s.substring(i).indexOf(s.substring(0, i)) != -1 || repetedWords.containsKey(subString); i++) {
				if(s.substring(i).indexOf(s.substring(0, i)) != -1){
					subString = s.substring(0, i);
					sEnd = s.substring(i);
				}
				if(repetedWords.containsKey(subString)){
					repetedWords.put(subString, repetedWords.get(subString) + 1);
				}
				existMatch = true;
				
				if(s.length() < i+1){
					break;
				}
				//
			}
			 if(!repetedWords.containsKey(subString) && existMatch) {
				repetedWords.put(subString, 1);
				s = sEnd;
			}else if(!existMatch){
				s = s.substring(1);
			}else{
				s = sEnd;
			}
			System.out.println("Substring: " + subString + "\nsEnd: " + sEnd);
			existMatch = false;
		}
		System.out.print(repetedWords.toString());
		return 0;
	}
}
