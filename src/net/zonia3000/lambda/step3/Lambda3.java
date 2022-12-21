package net.zonia3000.lambda.step3;

import java.util.function.BiFunction;

public class Lambda3 {

	public static void main(String[] args) {
		Calcolatrice calcolatrice = new Calcolatrice();
		int a = 5;
		int b = 3;
		double c = a;
		double d = b;
		
		BiFunction<Integer, Integer, Integer> somma = (x,y) -> x + y;
		BiFunction<Integer, Integer, Integer> dividi = (x,y) -> x / y;
		
		BiFunction<Double, Double, Double> sommaDouble = (x,y) -> x + y;
		BiFunction<Double, Double, Double> dividiDouble = (x,y) -> x / y;
		
		calcolatrice.esegui(somma, a, b);
		calcolatrice.esegui(dividi, a, b);
		
		calcolatrice.esegui(sommaDouble, c, d);
		calcolatrice.esegui(dividiDouble, c, d);
		
		calcolatrice.esegui(sommaDouble.andThen(r -> r / 2), c, d);
		
	}

}
