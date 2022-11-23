package manualejava9.cap15.par5;

public class IdealEconomy {

	public static void main(String args[]) {
		WareHouse wareHouse = new WareHouse();
		new Producer(wareHouse);
		new Consumer(wareHouse);
	}

}