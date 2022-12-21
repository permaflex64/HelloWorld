package manualejava9.cap16.par1;
//*puntatore al corpo della funzione ed allo stesso tempo creazione dell'oggetto.N.B. la classe (Runnable) ha una sola funzione (run)
// sintassi  ([lista di parametri]) -> {blocco di codice}

public class ClassiAnVsFunc {

	public static void main(String[] args) {
		//classe anonima
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Prima di Java 8: Classe anonima");
			}
		}).start();
		//lambda
		new Thread(() -> System.out.println("Da Java 8: Funzione anonima")).start();

		Runnable r = () -> System.out.println("Da Java 8: Funzione anonima 2");
		new Thread(r).start();

	}// main

}
