package vigenere;

import java.util.ArrayList;

import com.sun.org.apache.xpath.internal.FoundIndex;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * 1. Get cipher
 * 2. ???
 * 3. PROFIT!(and the original message)
 * @author JohannesH
 *
 */
public class CryptBreaker {
	public String breakCipher(String cipher){
		return "";
	}
	
	/**
	 * Finds the distance between the closest identical strings in a string
	 * @param cipher the string that's operated on
	 * @return an ArrayList of integers with the distances acquired
	 */
	private ArrayList<Integer> kasiski(String cipher){
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
		return null;
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
