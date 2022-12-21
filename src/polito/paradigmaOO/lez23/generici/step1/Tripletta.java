package polito.paradigmaOO.lez23.generici.step1;

import static org.junit.Assert.assertTrue;
import static polito.paradigmaOO.util.Util.*;

//import polito.paradigmaOO.util.Util;

public class Tripletta<T> {

	private T[] tripletta;

	public Tripletta(T a, T b, T c) {
		// ERRORE il tipo T non e' noto in questo contesto
		// this.tripletta = new T[] {a,b,c}; //cannot create a generic array of T
	}

	// soluzione 1  passare un array gia' creato esternamente
	public Tripletta(T a, T b, T c, T[] container) {
		tripletta = container;
		tripletta[0]=a;
		tripletta[1]=b;
		tripletta[2]=c;
	}

	// soluzione 2
//	public Tripletta(T[] els) {
//		tripletta = els.clone();
//	}

	// soluzione 3
	public Tripletta(T... els ) {
		if(!check(els,3)) {System.out.println("errore dimensione"); return;};
		tripletta = els.clone();
	}
	
	public static void creaTripletta() {
		Tripletta<String> t = new Tripletta<>("a","b","c");
		
		String[] ar = {"a","b","c"};
		t = new Tripletta<>(ar);
	}
	
//	private  boolean check(T[] els) {
//		return els.length == 3;
//	}
	
//	private static <T> boolean check(T[] els, int dimensione) {
//		return els.length == dimensione;
//	}
}
