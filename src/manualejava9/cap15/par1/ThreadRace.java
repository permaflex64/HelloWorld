package manualejava9.cap15.par1;

public class ThreadRace {

	public static void main(String[] args) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		Clicker hi = new Clicker(Thread.NORM_PRIORITY + 2);
		Clicker lo = new Clicker(Thread.NORM_PRIORITY - 2);
		hi.startThread();
		lo.startThread();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Thread principale interrotto");
		}
		hi.stopThread();
		lo.stopThread();
		System.out.println("Thread principale terminato, lo " + lo.getClick() + " vs hi " + hi.getClick());
	}
}
