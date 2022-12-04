package polito.paradigmaOO.lez26.timing.step1;

public class TimerTMSvsSB extends TimerTM {

	public TimerTMSvsSB(int n) {
		super(n);
	}

	@Override
	public void operazioneDaMisurare() {
		String s = "";
		for (int i = 0; i < MISURAZIONI; i++) {
			s += i;
		}

		if (visualizza)
			System.out.println(s);
	}

}
