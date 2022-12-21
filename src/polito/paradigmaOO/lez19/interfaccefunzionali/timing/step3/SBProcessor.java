package polito.paradigmaOO.lez19.interfaccefunzionali.timing.step3;

import polito.paradigmaOO.lez19.interfaccefunzionali.timing.step2.TimerBP;

public class SBProcessor {
	
	public void performProcessing() {
		StringBuffer sbuf = new StringBuffer("");
		for (int i = 0; i < TimerBP.MISURAZIONI; i++) {
			sbuf.append(i);

		}

		if (TimerBP.visualizza)
			System.out.println(sbuf);
	}

}
