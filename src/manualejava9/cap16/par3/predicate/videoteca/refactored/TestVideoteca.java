package manualejava9.cap16.par3.predicate.videoteca.refactored;

import java.util.function.Predicate;

public class TestVideoteca {
	public static void main(String args[]) {
		Predicate<Film> filtraBeiFilm = (film) -> film.getMediaRecensioni() > 3;
		Predicate<Film> filtraFilmFantascienza = (film) -> "Fantascienza".equals(film.getGenere());

		Videoteca videoteca = new Videoteca();
		System.out.println("Bei Film:");
//        Film[] beiFilms =   videoteca.getSceltaFilm((film) -> film.getMediaRecensioni() >3 );        
		Film[] beiFilms = videoteca.getSceltaFilm((filtraBeiFilm));
		stampaFilm(beiFilms);

		System.out.println("\nFilm di Fantascienza:");
//        Film[] filmDiFantascienza =   videoteca.getSceltaFilm((film) -> "Fantascienza".equals(film.getGenere()));
		Film[] filmDiFantascienza = videoteca.getSceltaFilm(filtraFilmFantascienza);
		stampaFilm(filmDiFantascienza);

		System.out.println("\nFilm belli di Fantascienza:");
		Film[] filmBelliDiFantascienza = videoteca.getSceltaFilm(filtraFilmFantascienza.and(filtraBeiFilm));
		stampaFilm(filmBelliDiFantascienza);

	}

	private static void stampaFilm(Film[] films) {
		for (Film film : films) {
			if (film != null) {
				System.out.println(film);
			}
		}
	}
}
