package polito.paradigmaOO.lez29_33.stream;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.*;

import polito.paradigmaOO.util.Quotations;

public class EsempiStreamBase {

	public static void main(String[] args) {
		
		String[] parole = Quotations.KAFKA.split("[ ,.-/'/?]+");
		
		for (String w : parole) {
			System.out.println(w);
		} 
		
		System.out.println("-------------------Arrays.asList 1----------------------------");
		Arrays.asList(parole).forEach((w) -> System.out.println(w));

		System.out.println("--------------------Arrays.asList 2---------------------------");
		Arrays.asList(parole).forEach(System.out::println);
		
		System.out.println("-------------------Arrays.stream----------------------------");
		Arrays.stream(parole).forEach(System.out::println);
		
		//FILTRAGGIO
		System.out.println("\n--------\nfilter():\n");
		Arrays.stream(parole).
		filter(w -> w.length()>3).
		forEach(System.out::println);
		
		System.out.println("\n--------\nlimit():\n");
		Arrays.stream(parole).
		limit(3).
		forEach(System.out::println);
		
		System.out.println("\n--------\nfilter() + limit():\n");
		Arrays.stream(parole).
		filter(w -> w.length()>3).
		limit(3).
		forEach(System.out::println);

		//ATTENZIONE:l'ordine e' importante
		System.out.println("\n--------\nfilter() + limit():\n");
		Arrays.stream(parole).
		limit(3).
		filter(w -> w.length()>3).
		forEach(System.out::println);
		
		System.out.println("\n--------\ncol for:\n");
		int n= 0;
		for (String w : parole) {
			if(w.length() > 3) {
			
				System.out.println(w);
				if(++n==3)break;
			}
		}//for
		
		System.out.println("\n--------\nskip(): salta le prime 20 quindi ne prende 3\n");
		Arrays.stream(parole).//Source
		skip(20).//Intermediate operation
		limit(3).//Intermediate operation
		forEach(System.out::println);//Terminal operation
		
		System.out.println("\n--------\nsorted():ordinamento alfabetico con ripetizioni\n ");
		Arrays.stream(parole).
		sorted().
		forEach(System.out::println);
		
		System.out.println("\n--------\nsorted() + distinct():ordinamento alfabetico senza ripetizioni\n ");
		Arrays.stream(parole).
		sorted().
		distinct().
		forEach(System.out::println);
		
		System.out.println("\n--------\nsorted() + distinct():con comparator ordinamento non alfabetico ma per lunghezza\n ");
		Arrays.stream(parole).
		sorted((x,y) -> x.length() - y.length()).
		distinct().
		forEach(System.out::println);
		
		System.out.println("\n--------\nsorted() + map():\nmap modifica ogni elemento e passa al successivo ");
		Arrays.stream(parole).
		map(w -> w.toLowerCase()).
		sorted().
		distinct().
		forEach(System.out::println);
		
		System.out.println("\n--------\nsorted() + distinct():ordinamento per lunghezza vari modi equivalenti\n ");
		Arrays.stream(parole).
//		sorted((x,y) -> x.length() - y.length()).
//		sorted(Comparator.comparingInt(w -> w.length())).
//		sorted(Comparator.comparingInt(String::length)).
		sorted(comparingInt(String::length)).
		distinct().
		forEach(System.out::println);

		
	}//main

}
