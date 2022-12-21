package manualejava9.cap16.par3.supplier;

public class Chitarra {
	
	private String marca;

	public Chitarra(String marca) {
		this.marca = marca;
		System.out.println("Creata chitarra: " + marca);
	}
	
	public void suona() {
		System.out.printf("sta suonando una %s ....",marca);
	}

}
