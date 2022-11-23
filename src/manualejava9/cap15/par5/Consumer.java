package manualejava9.cap15.par5;

public class Consumer implements Runnable {
	private WareHouse wareHouse;

	public Consumer(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
		new Thread(this, "Consumer").start();
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			wareHouse.get();
//			i = wareHouse.get();
		}
	}

//	public void run() {
//		for (int i = 0; i < 10; i++) {
//				 wareHouse.get();
//				 if(wareHouse.isEmpty())
//				 synchronized (wareHouse) {
//					wareHouse.notify();
//				}
//		}
//	}
//	public void run() {
//		for (int i = 0; i < 10; i++) {
//			if (!wareHouse.isEmpty())
//				i = wareHouse.get();
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
}
