package manualejava9.cap15.par5;

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

//	public void run() {
//		for (int i = 1; i <= 10; i++) {
//			try {
//				wareHouse.put(i);
//				if(!wareHouse.isEmpty())	
//				synchronized (wareHouse) {
//					wareHouse.wait();
//				}
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}

//	public void run() {
//		for (int i = 1; i <= 10; i++) {
//			wareHouse.put(i);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//	}
}
