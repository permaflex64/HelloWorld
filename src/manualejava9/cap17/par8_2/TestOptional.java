package manualejava9.cap17.par8_2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.Iterator;

import manualejava9.cap17.OggettoModificabile;
import manualejava9.cap17.Smartphone;

public class TestOptional {

	public TestOptional() {
	}

	public static void main(String[] args) {

		Consumer<Smartphone> smartTrovato = (s) -> System.out.println(s);
		Runnable smartNonTrovato = () -> System.out.println("Nessun telefonino trovato");

		System.out.println(getTitoloMaiuscolo("La Peste"));
		System.out.println(getTitoloMaiuscolo(null));
		System.out.println();
		System.out.println(getTitoloMaiuscoloOpt("La Peste"));
		System.out.println(getTitoloMaiuscoloOpt(null));

		System.out.println();

		Collection<Smartphone> smartpnones = caricaSmart();
		smartpnones.stream().filter((s) -> s.getMarca().equalsIgnoreCase("samsung")).findFirst()
				.ifPresentOrElse(s -> System.out.println(s), () -> System.out.println("Nessun telefonino trovato"));

		smartpnones.stream().filter((s) -> s.getMarca().equalsIgnoreCase("samsu")).findFirst()
				.ifPresentOrElse(smartTrovato, smartNonTrovato);

		System.out.println();
		OggettoModificabile om = new OggettoModificabile("Manuale di Java 9");
		
		System.out.println(isTitoloJava(om));
		System.out.println(isTitoloJava(null));
		om.setTitolo("Java");
		System.out.println(isTitoloJava(om));
		om.setTitolo("SQL");
		System.out.println(isTitoloJava(om));
		om.setTitolo(null);
		System.out.println(isTitoloJava(om));

	}

	public static String getTitoloMaiuscolo(String titolo) {
		if (titolo == null) {
			return ("NESSUN TITOLO");
		}

		return titolo.toUpperCase();
	}

	public static String getTitoloMaiuscoloOpt(String titolo) {
		return Optional.ofNullable(titolo).orElse("NESSUN TITOLO").toUpperCase();

	}
	
	public static boolean isTitoloJava(OggettoModificabile o) {
		
//		return Optional.ofNullable(o).map(OggettoModificabile::getTitolo).filter(t -> t.contains("Java")).isPresent() ;
		return Optional.ofNullable(o).map((t) -> t.getTitolo()).filter(s -> s.contains("Java")).isPresent() ;
	}
	
	

	static Collection<Smartphone> caricaSmart() {

		Collection<Smartphone> smartphones = new HashSet<>();
		smartphones.add(new Smartphone("Samsung", "Note 74"));
		smartphones.add(new Smartphone("Apple", "IPhone 225"));
		smartphones.add(new Smartphone("Motorola", "G55"));

		return smartphones;
	}

}
