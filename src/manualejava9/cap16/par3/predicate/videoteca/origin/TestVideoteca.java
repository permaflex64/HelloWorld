package manualejava9.cap16.par3.predicate.videoteca.origin;

public class TestVideoteca {
	public static void main(String args[]) {
		Videoteca videoteca = new Videoteca();
		System.out.println("Bei Film:");
//        Film[] beiFilms =   videoteca.getBeiFilm();
		Film[] beiFilms = videoteca.getSceltaFilm(new Criterio() {
			@Override
			public boolean valuta(Film film) {
				return film.getMediaRecensioni() > 3;
			}
		});
		stampaFilm(beiFilms);

		System.out.println("\nFilm di Fantascienza:");
//        Film[] filmDiFantascienza =   videoteca.getFilmDiFantascienza();
		Film[] filmDiFantascienza = videoteca.getSceltaFilm(new Criterio() {
			@Override
			public boolean valuta(Film film) {
				return "Fantascienza".equals(film.getGenere());
			}
		});
		stampaFilm(filmDiFantascienza);
	}

	private static void stampaFilm(Film[] films) {
		for (Film film : films) {
			if (film != null) {
				System.out.println(film);
			}
		}
	}
}
