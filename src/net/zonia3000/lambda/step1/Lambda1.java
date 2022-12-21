package net.zonia3000.lambda.step1;

import net.zonia3000.lambda.Calcolatrice;
import net.zonia3000.lambda.Operazione;

public class Lambda1 {

	public static void main(String[] args) {
		Calcolatrice calcolatrice = new Calcolatrice();

		int a = 7;
		int b = 3;
		
		Operazione somma = new Operazione() {
			
			@Override
			public int esegui(int a, int b) {
				return a + b;
			}
		};
	
	
		Operazione divisione = new Operazione() {
			
			@Override
			public int esegui(int a, int b) {
				return a/b;
			}
		};
		
		calcolatrice.esegui(somma, a, b);
		calcolatrice.esegui(divisione, a, b);
		
	}//main	

}
