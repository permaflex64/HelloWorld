package polito.paradigmaOO.lez19.interfaccefunzionali.timing.step1;

/**
 * Timer di attivita'
 * 
 * Utilizza il Template method
 */
public abstract class TimerTM {

	private int n;
	final static int MISURAZIONI = 40000;
	final static boolean visualizza = false;

	public TimerTM(int n) {
		this.n = n;
	}

	public double misura() {
		double totale = 0.0;
		for (int i = 0; i < n; i++) {
			long start = System.currentTimeMillis(); // Template method

			operazioneDaMisurare();

			long end = System.currentTimeMillis();
			totale = +end - start;
		}

		return totale / n;
	}

	public abstract void operazioneDaMisurare(); // Operation
}
