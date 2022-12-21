package polito.paradigmaOO.lez23.generici.step1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import static java.util.Comparator.*;


public class EsSorting {

	public static void main(String[] args) {
		Studente[] classe = generaArray();
			
		Arrays.sort(classe, 
					(a, b) -> a.getMatricola() - b.getMatricola());
		stampaStudente(classe);
		
		//EQUIVALE A
		Comparator<Studente> comp = (a, b) -> a.getMatricola() - b.getMatricola();
		Arrays.sort(classe,comp);
		
		Function<Studente, Integer> getter = Studente::getMatricola;
									//EQUIVALE A
									getter = s -> s.getMatricola();

		int m = getter.apply(classe[0]);
			//EQUIVALE A
			m = classe[0].getMatricola();
			
		classe = generaArray();
		Arrays.sort(classe,comparaCon(Studente::getMatricola));		
		stampaStudente(classe);
		//EQUIVALE A
		classe = generaArray();
		Arrays.sort(classe,Comparator.comparing(Studente::getMatricola));		
		stampaStudente(classe);
		
		//Ordine inverso
		classe = generaArray();
		Arrays.sort(classe, 
				(a, b) -> b.getMatricola() - a.getMatricola());
		stampaStudente(classe);
		//EQUIVALE A
		classe = generaArray();
		Arrays.sort(classe,Comparator.comparing(Studente::getMatricola).reversed());		
		stampaStudente(classe);
		
		//con import static di Comparator ho accesso diretto a tutti i suoi metodi statici
		classe = generaArray();
		Arrays.sort(classe,comparing(Studente::getMatricola).reversed());		
		stampaStudente(classe);
		
	}
	
	private static <T> Comparator<T> comparaCon(Function<T, Integer> estrattore){
		return (a,b) -> estrattore.apply(a) - estrattore.apply(b);
	}
	
	
	private static void stampaStudente(Studente[] classe) {
		for (Studente studente : classe) {
			System.out.println(studente);
		}
	}
	
	private static Studente[] generaArray() {
		Studente[] classe = { new Studente(10, "Mario", "Neri"), new Studente(5, "Luca", "Celi"),
			new Studente(9, "Anna", "Poli") };
		return classe;
	}

//	private static <T> Comparator<Studente> comparaCon(Function<Studente, Integer> f){
//		return (a,b) -> a.getMatricola() - b.getMatricola();
//	}
}
