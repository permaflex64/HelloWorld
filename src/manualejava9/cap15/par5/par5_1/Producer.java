package manualejava9.cap15.par5.par5_1;

public class Producer implements Runnable {
	private WareHouse wareHouse;

	public Producer(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
		new Thread(this, "Producer").start();
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			wareHouse.put(i);
		}
	}

}
