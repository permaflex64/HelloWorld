package manualejava9.cap16.par3.function.trasformastringhe;

import java.util.function.BiFunction;
import java.util.function.Function;

public class UtilStringa {

	public String concatena(BiFunction<String, String, String> trasformatore, String s1, String s2) {
		return trasformatore.apply(s1, s2);
	}

}
