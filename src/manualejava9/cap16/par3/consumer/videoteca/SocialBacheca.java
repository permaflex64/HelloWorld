package manualejava9.cap16.par3.consumer.videoteca;

import java.util.function.Consumer;

import manualejava9.cap16.par3.predicate.videoteca.refactored.Film;

public class SocialBacheca {
	
	public void aggiorna(Film film, Consumer<Film> consumer) {
		consumer.accept(film);
	}

}
