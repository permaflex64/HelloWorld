package manualejava9.cap15.par5.par5_1;

public class Consumer implements Runnable {
	private WareHouse wareHouse;

	public Consumer(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
		new Thread(this, "Consumer").start();
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			wareHouse.get();
		}
	}
}
