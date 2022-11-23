package manualejava9.cap15.par1;

public class ThreadCreation implements Runnable {

	public ThreadCreation() {
		Thread ct = Thread.currentThread();
		Thread t = new Thread(this, "Thread figlio");
		ct.setName("Thread principale");
		System.out.println("Thread principale creato: " + ct);
		System.out.println("Thread figlio creato" + t);
//		t.setPriority(Thread.MAX_PRIORITY);
//		ct.setPriority(Thread.MIN_PRIORITY);
		t.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Thread principale interrotto");
		}
		System.out.println("Uscita dal thread principale");
	}

	@Override
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				Thread.sleep(1000);
				System.out.println(i);
			}
		} catch (Exception e) {
			System.out.println("Thread figlio interrotto");
		}
	}

	public static void main(String[] args) {
		new ThreadCreation();
	}
}
