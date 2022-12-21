package manualejava9.cap16.par3;

import java.util.function.Predicate;

class TestPred<T>{
	
	public  boolean test(Predicate<T> p, T x) {
		boolean result = p.test(x);
		return result;
	}
}