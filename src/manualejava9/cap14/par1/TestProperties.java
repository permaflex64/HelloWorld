package manualejava9.cap14.par1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.util.*;

public class TestProperties {

	private static String PROP_PATH = "EJE.properties";

	public static void main(String[] args) throws Exception {
		Properties properties = System.getProperties();
		System.out.println(properties);

		testLeggiProperties();
		testCreaFile2();
		//testBundle();

	}

	private static Properties testLeggiProperties() throws Exception {
		Properties p = new Properties();
		File f = new File(PROP_PATH);
		System.out.println(f + " can read  " + f.canRead());
		FileInputStream fIn = new FileInputStream(PROP_PATH);
		p.load(fIn);
		System.out.println(p);
		return p;
	}

	private static void testCreaFile2() throws Exception {

		String[] coppie = { "saluto=ciao" };
		if (!new File("prova_it.properties").exists())
			creaFile("prova_it.properties", coppie);
		coppie[0] = "saluto=hello";
		if (!new File("prova_en.properties").exists())
			creaFile("prova_en.properties", coppie);
		if (!new File("prova.properties").exists())
			creaFile("prova.properties", coppie);
	}

	private static void creaFile(String nomeFile, String[] coppievalori) throws Exception {

		File f = new File(nomeFile);
		boolean exist = f.createNewFile();
		System.out.println(nomeFile + " creato -->" + exist + " scrivibile --> " + f.canWrite());

		FileOutputStream fout = new FileOutputStream(f);
		for (String string : coppievalori) {
			fout.write(string.getBytes());
		}

		fout.flush();

		FileInputStream fin = new FileInputStream(f);
		System.out.println(new String(fin.readAllBytes()));
	}

	private static void testBundle() {
		Locale itLoc = new Locale(Locale.ITALY.getLanguage());
		Locale enLoc = new Locale(Locale.ENGLISH.getLanguage());
		ResourceBundle bundle = ResourceBundle.getBundle("prova");
		System.out.println( "saluto italiano --> " + bundle.getObject("saluto"));
		
	}

	@Deprecated
	private static void testCreaFile() throws Exception {

		File f = new File("prova.properties");
		boolean exist = f.createNewFile();
		System.out.println("prova.properties creato -->" + exist + " scrivibile --> " + f.canWrite());

		FileOutputStream fout = new FileOutputStream(f);
		fout.write("saluto=hello".getBytes());
		fout.flush();

		FileInputStream fin = new FileInputStream(f);
		System.out.println(new String(fin.readAllBytes()));
	}

}
