package manualejava9.cap15.par1;

public class Caller implements Runnable {
	private CallMe target;
	private String msg;
	public Caller(CallMe target,String msg) {
		this.target = target;
		this.msg = msg;
		new Thread(this).start();
	}

	@Override
	public void run() {
		//synchronized (target) {
			target.call(msg);
		//}
	}

}
