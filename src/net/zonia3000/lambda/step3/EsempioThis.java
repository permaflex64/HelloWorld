package net.zonia3000.lambda.step3;

public class EsempioThis {

	String s = "attributo classe";

	public static void main(String[] args) {
		new EsempioThis().metodoConStringa();
	}

	public void metodoConStringa() {

		String s = "variabile locale metodo";

		Runnable r = new Runnable() {
			String s = "locale classe anonima";// sovrascrive la i locale al metodo

			@Override
			public void run() {

				System.out.println("call 1: " + s);
				System.out.println("call 2: " + this.s);
				System.out.println("call 3: " + EsempioThis.this.s);

			}
		};
		new Thread(r).start();

		r = new Runnable() {
			// String s = "locale classe anonima"; TOLTA
			@Override
			public void run() {

				System.out.println("call 4: " + s);
				// System.out.println("call 2: " + this.s); ERRORE
				System.out.println("call 5: " + EsempioThis.this.s);

			}
		};
		new Thread(r).start();

		r = () -> System.out.println("call 6: " + this.s);
		new Thread(r).start();

	}

}
