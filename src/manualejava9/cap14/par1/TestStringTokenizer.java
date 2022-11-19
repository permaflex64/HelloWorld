package manualejava9.cap14.par1;

import java.util.*;
import java.io.*;

public class TestStringTokenizer {

	public static void main(String[] args) throws Exception {
		String lorem = 	leggiLorem();
		
		StringTokenizer tokenizer = new StringTokenizer(lorem);
		stampaLorem(tokenizer);
		
		tokenizer = new StringTokenizer(lorem, "t");
		stampaLorem(tokenizer);
		
		tokenizer = new StringTokenizer(lorem, "t", false);
		stampaLorem(tokenizer);
		
		tokenizer = new StringTokenizer(lorem, "t", true);
		stampaLorem(tokenizer);
	}

	private static String leggiLorem() throws Exception {

		File lorem = new File("lorem_ipsum");
		if (lorem.exists())
			System.out.println("lorem c'e'");
		String content = new Scanner(lorem).useDelimiter("\\Z").next();
		return content;
	}
	
	private static void stampaLorem(StringTokenizer tokenizer) {
		//StringTokenizer tokenizer = new StringTokenizer(lorem, "t");
		Iterator testo = tokenizer.asIterator();
		int i = 0;
		while (testo.hasNext()) {
			String token = (String) testo.next();
			i++;
			System.out.println("token " + i + ": " + token);
		}
	}
}
