package polito.paradigmaOO.util;


public  class Util<T> {
	
	public static <T> boolean check(T[] els, int dimensione) {
		return els.length == dimensione;
	}
}
