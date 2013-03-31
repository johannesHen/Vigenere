package vigenere;

import java.util.HashMap;
import java.util.Map.Entry;

/*
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
	public static HashMap<String, Float> AnalyseText(String text) {
		
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
	
}
