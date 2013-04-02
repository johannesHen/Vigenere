package vigenere;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Class to analyze the letter frequencies of a text.
 * @author Rasmus Précenth
 */
public class FrequencyFinder {
	/**
	 * Finds the frequency of each character of the alpahabet {a,b,..,ö} in the supplied text.
	 * @param text the text that is analyzed.
	 * @return A hashmap where the key is the character in string form and the value is the frequency 
	 * of the character in the text
	 */
	/*
	 * Should we restrict(and enforce) the keys to our alphabet? If so, we don't need to check if a character
	 * exists in the hash before we use it. On the other hand we would need to bloat this class by adding a bunch
	 * of lines of code. It's also more general this way.
	 */
	public static HashMap<String, Float> analyseText(String text) {
		
		HashMap<String, Integer> occurrenceTable = new HashMap<String, Integer>();
		
		for(int i = 0;i < 26;i++){
			char c = (char)(i+97);
			occurrenceTable.put(String.valueOf(c), 0);
		}
		occurrenceTable.put("å", 0);
		occurrenceTable.put("ä", 0);
		occurrenceTable.put("ö", 0);
		for (int i = 0; i < text.length(); i++) {
			String currentChar = String.valueOf(text.charAt(i));
			try{//while catch if gets null + 1
				occurrenceTable.put(currentChar, occurrenceTable.get(currentChar) + 1);
			}catch(Exception e){
				System.out.println("Text contained characters not in the alphabet");
				e.printStackTrace();
			}
		}

		HashMap<String, Float> results = new HashMap<String, Float>();
		for	(Entry<String, Integer> kv : occurrenceTable.entrySet()) {
			results.put(kv.getKey(), kv.getValue().floatValue() / text.length());
		}
		
		return results;
	}
	/**
	 * The standard Swedish letter frequency according to http://en.wikipedia.org/wiki/Letter_frequency
	 * @return A hashmap where the keys are the string form of the characters in the alphabet,{a,..,ö},
	 * and the values are the decimal form of the average frequencies in the Swedish language 
	 */
	public static HashMap<String, Float> getStandardSwedishFrequency(){
		HashMap<String, Float> result = new HashMap<String, Float>();
		
		result.put("a", 0.093f);
		result.put("b", 0.013f);
		result.put("c", 0.013f);
		result.put("d", 0.045f);
		result.put("e", 0.099f);
		result.put("f", 0.020f);
		result.put("g", 0.033f);
		result.put("h", 0.021f);
		result.put("i", 0.051f);
		result.put("j", 0.007f);
		result.put("k", 0.032f);
		result.put("l", 0.052f);
		result.put("m", 0.035f);
		result.put("n", 0.088f);
		result.put("o", 0.041f);
		result.put("p", 0.017f);
		result.put("q", 0.00007f);
		result.put("r", 0.083f);
		result.put("s", 0.063f);
		result.put("t", 0.087f);
		result.put("u", 0.018f);
		result.put("v", 0.024f);
		result.put("w", 0.0003f);
		result.put("x", 0.001f);
		result.put("y", 0.006f);
		result.put("z", 0.0002f);
		result.put("å", 0.016f);
		result.put("ä", 0.021f);
		result.put("ö", 0.015f);
		
		return result;
	}
	
}
