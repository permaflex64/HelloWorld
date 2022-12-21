package manualejava9.cap16.par3.consumer.videoteca;

import java.util.function.Consumer;

import manualejava9.cap16.par3.predicate.videoteca.refactored.*;

public class TestVideoteca {

	public static void main(String[] args) {
		Consumer<Film> aggiornaVoto = (film) -> film.setMediaRecensioni(5); 
		Consumer<Film> aggiornaNome = (film) -> film.setNome("Stars Wars episodio 1 - La minaccia fanstasma"); 
		
		Videoteca videoteca = new Videoteca();
		Film[] films = videoteca.getFilms();
		Film lanternaverde = films[7];
		System.out.println("prima: " + lanternaverde);
		
		new SocialBacheca().aggiorna(lanternaverde, aggiornaVoto);
		System.out.println("dopo: " + lanternaverde);

		Film starwars = films[1];
		System.out.println("prima: " + starwars);
		
		new SocialBacheca().aggiorna(starwars, aggiornaVoto.andThen(aggiornaNome));
		System.out.println("dopo: " + starwars);
	}

}
