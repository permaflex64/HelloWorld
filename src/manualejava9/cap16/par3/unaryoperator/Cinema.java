package manualejava9.cap16.par3.unaryoperator;

import java.util.function.UnaryOperator;

public class Cinema {

	public static UnaryOperator<ProgrammazioneFilm> componiCambi(UnaryOperator<ProgrammazioneFilm> op1,
			UnaryOperator<ProgrammazioneFilm> op2) {

		return x -> op2.apply(op1.apply(x));
	}

	public static ProgrammazioneFilm cambiaProgrammazione(ProgrammazioneFilm pf1,
			UnaryOperator<ProgrammazioneFilm> op) {

		return op.apply(pf1);
	}

}
