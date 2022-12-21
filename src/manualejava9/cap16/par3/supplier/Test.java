package manualejava9.cap16.par3.supplier;

import java.util.function.Supplier;

public class Test {

	public static void main(String[] args) {
		Supplier<Chitarra> ibanez = () -> new Chitarra("Ibanez");
		new Chitarrista().suonaChitarra(ibanez);
	}

}
