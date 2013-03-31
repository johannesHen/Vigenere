package vigenere;

import java.util.ArrayList;

import com.sun.org.apache.xpath.internal.FoundIndex;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Class for decryting a cipher encrypted with the Vigenere cipher.
 * @author JohannesH
 *
 */
public class CryptBreaker {
	public String breakCipher(String cipher){
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
		ArrayList<Integer> acc = new ArrayList<Integer>();
		int i = 3,foundIndex, maxFound  = 0;
		boolean stillFinding = true;
		String subString = "";
		while (stillFinding) {
			subString = cipher.substring(0, i);
			foundIndex = cipher.indexOf(subString,i);
			if(foundIndex != -1){ //Found match
				maxFound = foundIndex - i;
			}else{
				cipher = cipher.substring(i);
				if(maxFound > 0)
					acc.add(maxFound);
				stillFinding = false;
				maxFound = 0;
			}
		}
		return 0;
	}
	
	private String mostRepeated(String s){
		int i = 3,foundIndex, maxFound  = 0,matchesFound = 0;
		
		boolean stillFinding = true;
		String subString = "";
		for(int n = 0;n < s.length();n++){
			subString = s.substring(0, 4);
			foundIndex = s.indexOf(subString,4);
			if(foundIndex != -1){ //Found match
				matchesFound++;
			}else{
				s = s.substring(i);
				if(maxFound > 0)
					
				stillFinding = false;
				maxFound = 0;
			}
		}
		while (stillFinding) {
			
			
			
		}
		return "";
	}
}
