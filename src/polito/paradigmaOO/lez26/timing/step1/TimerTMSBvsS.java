package polito.paradigmaOO.lez26.timing.step1;

public class TimerTMSBvsS extends TimerTM {

	public TimerTMSBvsS(int n) {
		super(n);
	}

	@Override
	public void operazioneDaMisurare() {
		StringBuffer sbuf = new StringBuffer("");
		for (int i = 0; i < MISURAZIONI; i++) {
			sbuf.append(i);

		}

		if (visualizza)
			System.out.println(sbuf);
	}
}
