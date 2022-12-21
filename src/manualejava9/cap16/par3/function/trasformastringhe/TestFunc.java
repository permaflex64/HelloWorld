package manualejava9.cap16.par3.function.trasformastringhe;

import java.util.function.BiFunction;

public class TestFunc {

	public static void main(String[] args) {
		BiFunction<String, String, String> concatenaConTrattino = (s1,s2) ->  s1 + "-" + s2;
		String concatenata = new UtilStringa().concatena(concatenaConTrattino, "Hello", "BiFunction");
		System.out.println(concatenata);
		
		concatenata = new String(concatenaConTrattino.apply("Hello", "BiFunction") + "!!");
		System.out.println(concatenata);
	}
}
