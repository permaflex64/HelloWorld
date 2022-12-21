package polito.paradigmaOO.lez23.generici.step1;

public class Studente {

	int matricola;
	String nome;
	String cognome;

	public Studente(int matricola, String nome, String cognome) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}

	public int getMatricola() {
		return matricola;
	}

	@Override
	public String toString() {
		return "(" + matricola + ")" + " " + nome + " " + cognome;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof String))
			return false;
		if (matricola == ((Studente) obj).matricola)
			return true;
		else
			return false;

	}
}
