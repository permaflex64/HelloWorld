package polito.paradigmaOO.lez19.interfaccefunzionali.timing.step2;

public class EsempioLambda {

	public static void main(String[] args) {
		TimerBP timer = new TimerBP(10, () -> {

			String s = "";
			for (int i = 0; i < TimerBP.MISURAZIONI; i++) {
				s += i;
			}

			if (TimerBP.visualizza)
				System.out.println(s);

		});

		double time = timer.misura();
		System.out.printf("%f", time);
		System.out.println();

		timer = new TimerBP(10, () -> {

			StringBuffer sbuf = new StringBuffer("");
			for (int i = 0; i < TimerBP.MISURAZIONI; i++) {
				sbuf.append(i);

			}

			if (TimerBP.visualizza)
				System.out.println(sbuf);
		});

		time = timer.misura();
		System.out.printf("%f", time);
	}

}
