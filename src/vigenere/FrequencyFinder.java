package vigenere;

import java.util.HashMap;
import java.util.Map.Entry;

/*
 * Class to analyse the letter frequencies of a text.
 * @author Rasmus Précenth
 */
public class FrequencyFinder {
	/**
	 * Finds the frequency of each character present in the supplied text.
	 * @param text the text that is analyzed.
	 * @return A hashmap where the key is the character in string form and the value is the frequency 
	 * of the character in the text
	 */
	public static HashMap<String, Float> AnalyseText(String text) {
		
		HashMap<String, Integer> occurrenceTable = new HashMap<String, Integer>(); 
		
		for (int i = 0; i < text.length(); i++) {
			
			String currentChar = String.valueOf(text.charAt(i));
			
			if (!occurrenceTable.containsKey(currentChar))
				occurrenceTable.put(currentChar, 1);
			else
				occurrenceTable.put(currentChar, 1 + occurrenceTable.get(currentChar));
		}

		HashMap<String, Float> results = new HashMap<String, Float>();
		for	(Entry<String, Integer> kv : occurrenceTable.entrySet()) {
			results.put(kv.getKey(), kv.getValue().floatValue() / text.length());
		}
		
		return results;
	}
	
}
