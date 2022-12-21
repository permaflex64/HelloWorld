package manualejava9.cap18.par_3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.stream.Stream;

public class TestFile {

	// static String pathIn = File.separator + "HelloWorld" + File.separator +
	// "lorem_ipsum";
	static String pathIn = "lorem_ipsum";
	static String pathOut = "lorem_ipsum_copy";

	public TestFile() {
	}

	public static void main(String[] args) {

		System.out.println(pathIn);
		copiaFile4(pathIn, pathOut);

	}

	public static void copiaFile(String pathIn, String pathOut) {

		FileInputStream fin = null;
		FileOutputStream fout = null;

		try {

			fin = new FileInputStream(pathIn);
			fout = new FileOutputStream(pathOut);

			byte[] buff = new byte[1024];
			int bytesRead = 0;

			while ((bytesRead = fin.read(buff)) >= 0) {
				fout.write(buff, 0, bytesRead);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fin != null) {

					fin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fout != null) {

					fout.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void copiaFile1(String pathIn, String pathOut) {
		try (FileInputStream fin = new FileInputStream(pathIn); FileOutputStream fout = new FileOutputStream(pathOut)) {

			byte[] buff = new byte[1024];
			int bytesRead = 0;

			while ((bytesRead = fin.read(buff)) >= 0) {
				fout.write(buff, 0, bytesRead);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void copiaFile2(String pathIn, String pathOut) {
		try (BufferedReader fin = new BufferedReader(new FileReader(pathIn));
				BufferedWriter fout = new BufferedWriter(new FileWriter(pathOut))) {

			String buff = "";

			while ((buff = fin.readLine()) != null) {
				fout.write(buff + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void copiaFile3(String pathIn, String pathOut) {
		try (BufferedReader fin = new BufferedReader(new FileReader(pathIn));
				BufferedWriter fout = new BufferedWriter(new FileWriter(pathOut))) {

			Stream<String> lines = fin.lines();
			// System.out.println(lines.count()); ERRORE chiude lo stream dopo l'uso
			lines.forEach((s) -> {
				try {
					fout.write(s); // problema del lancio eccezione vedi zonia3000
				} catch (IOException e) { // non funziona neanche facendo lanciare eccez al metodo
					e.printStackTrace();
				}
			});

//				fout.write(buff + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void copiaFile4(String pathIn, String pathOut) {
		try (BufferedReader fin = new BufferedReader(new FileReader(pathIn));
				MyBufferedWriter fout = new MyBufferedWriter(new FileWriter(pathOut))) {

			Stream<String> lines = fin.lines();
			lines.forEach((s) -> fout.write(s + "\n")); // problema del lancio eccezione vedi zonia3000
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Wrapper risolve problema lancio eccezione checked dall'interno della lambda
	public static class MyBufferedWriter extends BufferedWriter {

		Writer out;
		
		public MyBufferedWriter(Writer out) {
			super(out);
			this.out = out;
		}

		@Override
		public void write(String str) {

			try {
				super.write(str);
			} catch (IOException e) {
				e.printStackTrace(); // TODO fargli lanciare una unchecked exception dal finally
				

			} finally {
				if (this.out != null) {
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
