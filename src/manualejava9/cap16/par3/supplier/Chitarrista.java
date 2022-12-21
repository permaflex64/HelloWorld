package manualejava9.cap16.par3.supplier;

import java.util.function.Supplier;

public class Chitarrista {
	
	public void suonaChitarra(Supplier<Chitarra> marcaSupplier) {
		marcaSupplier.get().suona();
	}

}
