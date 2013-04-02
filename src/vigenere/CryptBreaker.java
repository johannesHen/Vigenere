package vigenere;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.regex.*;

/**
 * Class for breaking a cipher encrypted with the Vigenere cipher.
 * 
 * @author JohannesH
 * 
 */

/*
 * Algorithm:
 * 1. Find the key length, m.
 * 2. Divide the text in m parts.
 * 3. Analyze the letter frequency for each part of text separately and find a most probable
 * 	  key value for each part.
 * 4. Merge the keys for each part and try to decrypt the cipher-text with it.
 */
public class CryptBreaker {
	
	/**
	 * Tries to find the key to a cipher-text by frequency analysis. 
	 * @param cipher The cipher we are trying to find the key to.
	 * @return The key determined to be most probable. 
	 */
	public static String breakCipher(String cipher) {
		int keyLenght = 15;//The lenght of our key.
		String[] dividedText = divideText(cipher,keyLenght);
		
		String result = "";
		for(String s : dividedText){
			System.out.println(s);
			result += findMostProbableKey(s);
		}
		
		return result;
	}

	public static String findMostProbableKey(String text){
		CryptHandler ch = new CryptHandler();
		String keyAppliedText, bestTryKey = "";
		Float letterFreq, normalLetterFreq, bestTryValue = 1.0f;
		normalLetterFreq = FrequencyFinder.getStandardSwedishIoc();
		for(int i = 0;i < 29; i++){
			String currentKey = "";
			if(i < 26){
				currentKey = String.valueOf((char)(i+97));
			}else if(i == 26){
				currentKey = "å";
			}else if(i == 27){
				currentKey = "ä";
			}else if(i == 28){
				currentKey = "ö";
			}
			keyAppliedText = ch.decrypt(text, currentKey);
			letterFreq = FrequencyFinder.ioc(keyAppliedText);
			if(Math.abs(normalLetterFreq-letterFreq) < bestTryValue){
				bestTryKey = currentKey;
				bestTryValue = Math.abs(normalLetterFreq-letterFreq);
			}
		}
		return bestTryKey;
	}
	
	private static String[] divideText(String text, int keyLength){
		String[] result = new String[keyLength];
		for(int i = 0;i < keyLength;i++){
			result[i] = "";
		}
		for(int i = 0; i < text.length();i++){
			result[i % keyLength] += String.valueOf(text.charAt(i));
		}
		return result;
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
			//System.out.println("Substring: " + subString + "\nsEnd: " + sEnd);
			existMatch = false;
		}
		//System.out.print(repetedWords.toString());
		return 0;
	}
}
