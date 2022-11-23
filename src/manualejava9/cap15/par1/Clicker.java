package manualejava9.cap15.par1;

public class Clicker implements Runnable {

	private long click = 0L;
	private Thread t;
	private volatile boolean running = true;
	
	public Clicker(int p) {
		t = new Thread(this);
		t.setPriority(p);
	}

	@Override
	public void run() {
		while (running) {
			click++;
		}
	}

	public long getClick() {
		return click;
	}
	
	
	public void stopThread() {
		running = false;
	}
	
	public void startThread() {
		running = true;
		t.start();
	}
}
