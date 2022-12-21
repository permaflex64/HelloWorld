package polito.paradigmaOO.lez24.collezioni;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;
import java.util.concurrent.PriorityBlockingQueue;

public class EsempiCollezioni {

	public static void main(String[] args) {

		Collection<String> c = generaCollection(new ArrayList<String>());
		stampaCollection(c);
		c = generaCollection(new TreeSet<String>());
		stampaCollection(c);
		c = generaCollection(new LinkedList<String>());
		stampaCollection(c);
		c = generaCollection(new HashSet<String>());
		stampaCollection(c);

		LinkedList<String> l = (LinkedList<String>) generaCollection(new LinkedList<>());
		l.add(1, "Andrea");
		// l.add(20, "ERRORE"); Out of Bounds
		System.out.println("Secondo elemento: " + l.get(1));
		stampaCollection(l);

		Queue<Integer> fifo = generaCoda(new LinkedList<>());
		stampaCollection(fifo);
		Queue<Integer> q = generaCoda(new PriorityQueue<>());// in testa l'elemento piu piccolo
		stampaCollection(q);
		
		
		//----------MAP--------------
		
		Map<String,String> dizionario = new HashMap<>();
		
		dizionario.put("bianco", "white");
		dizionario.put("rosso", "red");
		dizionario.put("verde", "green");
		dizionario.put("blu", "blu");
		dizionario.put("giallo", "yellow");
		
		System.out.println("In Inglese verde si dice " + dizionario.get("verde"));
		System.out.println("In Italiano green si dice " + dizionario.get("green"));//ERRORE
		
		if(!dizionario.containsKey("magenta")) System.out.println("Chiave non presente");
		
		

	}

	private static void stampaCollection(Collection<?> c) {
		c.forEach(p -> System.out.println(p) ); 
	}


	private static Collection<String> generaCollection(Collection<String> ci) {
		System.out.println(ci.getClass());
		ci.clear();

		Collection<String> c = ci;

		c.add("Neri");
		c.add("Mario");
		c.add("Luca");
		c.add("Celi");
		c.add("Poli");
		c.add("Anna");

		return c;
	}

	private static Queue<Integer> generaCoda(Queue<Integer> qi) {
		System.out.println(qi.getClass());
		qi.clear();

		Queue<Integer> q = qi;

		q.add(3);
		q.add(6);
		q.add(1);
		q.add(5);
		q.add(4);
		q.add(2);

		return q;
	}
}
