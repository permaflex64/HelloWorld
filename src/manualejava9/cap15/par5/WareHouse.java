package manualejava9.cap15.par5;

public /*final*/ class WareHouse {
	private int idProduct;
	private int numberOfProducts;
	
	public WareHouse() {
		numberOfProducts = 0;
	}
	
	public synchronized boolean isEmpty() {
		return numberOfProducts < 1;
	}

	public synchronized int get() {
		numberOfProducts--;
		printSituation("Consumed " + idProduct);
		return numberOfProducts;
	}

	public synchronized void put(int idProduct) {
		this.idProduct = idProduct;
		numberOfProducts++;
		printSituation("Produced " + idProduct);
	}

	private synchronized void printSituation(String msg) {
		System.out.println(msg + "\n" + numberOfProducts + " Products in warehosue");
	}

}
