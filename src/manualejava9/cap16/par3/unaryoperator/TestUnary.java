package manualejava9.cap16.par3.unaryoperator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.UnaryOperator;

import manualejava9.cap16.par3.predicate.videoteca.refactored.Film;

public class TestUnary {

	public static void main(String[] args) {
		UnaryOperator<ProgrammazioneFilm> ritardaDiUnOra = p -> {
			LocalTime t = p.getOrario().plusHours(1);
			p.setOrario(t);
			return p;
		};
		
		UnaryOperator<ProgrammazioneFilm> ritardaDiUnGiorno = p -> {
			 p.setData(p.getData().plusDays(1));
			 return p;
		};
		
		
		Film film = new Film("Harry Potter", "fantasy", 4);
		ProgrammazioneFilm pf = new ProgrammazioneFilm(LocalTime.of(21, 0), LocalDate.of(2023, 1, 6), film);
		UnaryOperator<ProgrammazioneFilm> ritardaDiUnOraedUnGiorno = Cinema.componiCambi(ritardaDiUnOra, ritardaDiUnGiorno);
		Cinema.cambiaProgrammazione(pf, ritardaDiUnOraedUnGiorno);
		System.out.println(pf);
	}

}
