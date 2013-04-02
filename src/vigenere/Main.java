package vigenere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

/**
 * 
 * @author JohannesH
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//<paths, ciphers>
		HashMap<Path,String> ciphersRead = new HashMap<Path,String>();
		Path groupCryptosFiles = Paths.get("GroupCryptos");
		Path taCryptosFiles = Paths.get("TaCryptos");
		try {
			DirectoryStream<Path> groupFilesStream = Files
					.newDirectoryStream(groupCryptosFiles);
			DirectoryStream<Path> taFilesStream = Files
					.newDirectoryStream(taCryptosFiles);
			for (Path entry : groupFilesStream) {
				if(entry.toString().endsWith(".crypto")){
					String cipher = readFile(entry);
					ciphersRead.put(entry,cipher);
				}
					
			}
			for (Path entry : taFilesStream) {
				String cipher = readFile(entry);
				ciphersRead.put(entry,cipher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		for	(Entry<Path, String> kv : ciphersRead.entrySet()) {
			System.out.println("Trying to break file: " + kv.getKey()+
					"\nInput cipher: " + kv.getValue());
			String breakAttemt = CryptBreaker.breakCipher(kv.getValue());
			System.out.println("Result from attemt: " + breakAttemt + "\n");
			
		}
		
		CryptBreaker.mostRepeated("hejdejlefhejnejhejdd");
		/*String message = "varsågod";//ciphersRead.get(Paths.get("GroupCryptos/vig_group8.crypto"));

		CryptHandler ch = new CryptHandler();
		String enc, dec;

		enc = ch.encrypt(message, "tack");
		dec = ch.decrypt(enc, "tack");
		System.out.println("dec lenght: " + dec.length());
		System.out.println("Encrypted: " + enc);
		System.out.println("Decrypted: " + dec);
		
		HashMap<String,Float> hm = new HashMap<String, Float>();
		hm = FrequencyFinder.getStandardSwedishFrequency();
		float acc = 0;
		for(Entry<String,Float> kv : hm.entrySet()){
			acc += kv.getValue();
		}
		System.out.println("freq sum: " + acc + "\nsize: " + hm.size());*/
	}
	
	private static String readFile(Path p) throws IOException{
		BufferedReader reader = Files.newBufferedReader(p, Charset.forName("UTF-8"));
		int intRead;
		String acc = "";
		while((intRead = reader.read()) != -1){
			acc += (char)intRead;
		}
		return acc;
	}
}
