package net.zonia3000.lambda.step2;

import net.zonia3000.lambda.Calcolatrice;
import net.zonia3000.lambda.Operazione;

public class Lambda1 {

	public static void main(String[] args) {
		Calcolatrice calcolatrice = new Calcolatrice();

		int a = 7;
		int b = 3;
		
		Operazione somma = (x,y) -> x + y;			
		Operazione divisione = (x,y) -> x/y;
			
		
		calcolatrice.esegui(somma, a, b);
		calcolatrice.esegui(divisione, a, b);
		
	}//main	

}
