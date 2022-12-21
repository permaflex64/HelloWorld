package polito.paradigmaOO.lez19.interfaccefunzionali.timing.step1;

public class Esempio {

	public static void main(String[] args) {
		TimerTM t = new TimerTMSvsSB(10);
		double m = t.misura();
		System.out.printf("%f", m);
		
		System.out.println();
		
		t = new TimerTMSBvsS(10);
		m = t.misura();
		System.out.printf("%f", m);
	}

}
