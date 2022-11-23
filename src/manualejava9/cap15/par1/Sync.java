package manualejava9.cap15.par1;

public class Sync {

	public static void main(String[] args) {
		CallMe target = new CallMe();
		new Caller(target,"Hello");
		new Caller(target,"Synchronized");
		new Caller(target,"World");
	}

}
