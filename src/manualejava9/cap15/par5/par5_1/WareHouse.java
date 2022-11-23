package manualejava9.cap15.par5.par5_1;

public class WareHouse {
	private int numberOfProducts;
	private int idProduct;
	private boolean empty = true; // magazzino vuoto

	public synchronized void put(int idProduct) {
		if (!empty) // se il magazzino non è vuoto...
			try {
				wait(); // fermati Producer
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		this.idProduct = idProduct;
		numberOfProducts++;
		printSituation("Produced " + idProduct);
		empty = false;
		notify(); // svegliati Consumer
	}

	public synchronized int get() {
		if (empty) // se il magazzino è vuoto...
			try {
				wait(); // bloccati Consumer
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		numberOfProducts--;
		printSituation("Consumed " + idProduct);
		empty = true; // il magazzino ora è vuoto
		notify(); // svegliati Producer
		return idProduct;
	}

	private synchronized void printSituation(String msg) {
		System.out.println(msg + "\n" + numberOfProducts + " Product in Warehouse");
	}

}
