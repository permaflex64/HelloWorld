package manualejava9.cap14.par1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class TestRegularExpr {

	public static void main(String[] args) throws Exception {
		String lorem = leggiLorem();
		System.out.println(lorem);

		cercaLorem("[l|L]orem", lorem);
	}

	private static void cercaLorem(String pattern, String lorem) throws Exception {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(lorem);
		while (m.find()) {
			int start = m.start();
			int end = m.end();
			System.out.println("match start: " + start + ", end: " + end);
		}
	}

	private static String leggiLorem() throws Exception {

		File lorem = new File("lorem_ipsum");
		if (lorem.exists())
			System.out.println("lorem c'e'");
		//leggo l'intero file \Z ne delimita la fine
		String content = new Scanner(lorem).useDelimiter("\\Z").next();
		return content;
	}

//	private static void stampaLorem(StringTokenizer tokenizer) {
//		//StringTokenizer tokenizer = new StringTokenizer(lorem, "t");
//		Iterator testo = tokenizer.asIterator();
//		int i = 0;
//		while (testo.hasNext()) {
//			String token = (String) testo.next();
//			i++;
//			System.out.println("token " + i + ": " + token);
//		}
//	}

}
