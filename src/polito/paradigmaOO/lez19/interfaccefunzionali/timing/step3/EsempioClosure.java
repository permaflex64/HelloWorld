package polito.paradigmaOO.lez19.interfaccefunzionali.timing.step3;

import polito.paradigmaOO.lez19.interfaccefunzionali.timing.step2.TimerBP;

public class EsempioClosure {

	public static void main(String[] args) {
		//creare una classe esterna(SBProcessor) al posto
		//di una classe anonima torna utile in caso di riuso
		var timer = new TimerBP(10, () -> {
			SBProcessor p = new SBProcessor();
			p.performProcessing();
		});

		double elapsed = timer.misura();
		System.out.printf("%f", elapsed);
		System.out.println("");

		timer = new TimerBP(10, () -> {
			SProcessor p = new SProcessor();
			p.performProcessing();
		});

		elapsed = timer.misura();
		System.out.printf("%f", elapsed);
		System.out.println();

		SBProcessor p = new SBProcessor();
		timer = new TimerBP(10, () -> {
			p.performProcessing();
			// p fa parte della "closure" del nuovo
			// oggetto creato tramite lamda expression
		});
		// p potrebbe cambiare prima del completamento del metodo
		// p = new SBProcessor(); errore!
		elapsed = timer.misura();
		System.out.printf("%f", elapsed);
		System.out.println();

		// la lambda con closure equivale (circa) a

		class TaskConClosure implements Runnable {
			private SBProcessor p;

			public TaskConClosure(SBProcessor p) {
				this.p = p;
			}

			@Override
			public void run() {
				p.performProcessing();
			}

		}
		
		timer = new TimerBP(10, new TaskConClosure(p));

		//method reference
		timer = new TimerBP(10, p::performProcessing);
		
	}// main

}
