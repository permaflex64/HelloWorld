package polito.paradigmaOO.lez19.interfaccefunzionali.timing.step3;

import polito.paradigmaOO.lez19.interfaccefunzionali.timing.step2.TimerBP;

public class SProcessor {
	
	public void performProcessing() {
		String s = "";
		for (int i = 0; i < TimerBP.MISURAZIONI; i++) {
			s += i;
		}

		if (TimerBP.visualizza)
			System.out.println(s);

	}

}
