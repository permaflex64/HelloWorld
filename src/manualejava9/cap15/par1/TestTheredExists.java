package manualejava9.cap15.par1;

public class TestTheredExists {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		t.setName("thread principale");
		t.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Thread in esecuzione: " + t);
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println(i);
				t.sleep(700);
			}
		} catch (InterruptedException e) {
			//e.printStackTrace();
			System.out.println("Thread interrotto");
		}

	}

}
