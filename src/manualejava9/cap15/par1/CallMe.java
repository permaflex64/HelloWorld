package manualejava9.cap15.par1;

public class CallMe {
	public synchronized void call(String msg) {
		System.out.println("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		System.out.println("]");
	}
}
