package polito.paradigmaOO.lez26.timing.step2;

/**
 * Timer di attivita'
 * 
 * Usa la behavioral parametrization, cioe' i parametri non passano valori ma
 * comportamenti
 */
public class TimerBP {
	
//	public interface Task {
//		void run();
//	}

	private int ripetizioni;
	private Runnable task;
	public final static int MISURAZIONI = 40000;
	public final static boolean visualizza = false;

	public TimerBP(int ripetizioni, Runnable bp) {
		this.ripetizioni = ripetizioni;
		this.task = bp;
	}

	public double misura() {
		double totale = 0.0;
		for (int i = 0; i < ripetizioni; i++) {
			long start = System.currentTimeMillis(); 

			task.run();
			
			long end = System.currentTimeMillis();
			totale = +end - start;
		}

		return totale / ripetizioni;
	}

}
