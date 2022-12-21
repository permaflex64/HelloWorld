package manualejava9.cap16.par3.unaryoperator;

import java.time.LocalDate;
import java.time.LocalTime;
import manualejava9.cap16.par3.predicate.videoteca.refactored.Film;

public class ProgrammazioneFilm {
	private LocalTime orario;
	private LocalDate data;
	private Film proiezione;

	public ProgrammazioneFilm(LocalTime orario, LocalDate data, Film proiezione) {
		this.orario = orario;
		this.data = data;
		this.proiezione = proiezione;
	}

	@Override
	public String toString() {
		return "Il film " + proiezione.getNome() + " verra proiettato il giorno " + data + " alle " + orario;
	}

	public LocalTime getOrario() {
		return orario;
	}

	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Film getProiezione() {
		return proiezione;
	}

	public void setProiezione(Film proiezione) {
		this.proiezione = proiezione;
	}

}
