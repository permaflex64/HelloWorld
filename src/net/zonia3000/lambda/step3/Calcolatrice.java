package net.zonia3000.lambda.step3;

import java.util.function.BiFunction;

public class Calcolatrice {

	public Calcolatrice() {
	}

//	public  int esegui(BiFunction<Integer, Integer, Integer> operazione, int a, int b) {
//		return operazione.apply(a, b);
//	}
	public <T,R> R esegui(BiFunction<T, T, R> operazione, T a, T b) {
		R result = operazione.apply( a,  b);
		System.out.println(result);
		return result;
	}
}
