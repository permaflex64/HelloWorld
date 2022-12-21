package manualejava9.cap16.par3;

import java.util.function.Predicate;

public class TestFun<T> {
	
	static Predicate<Integer> _isPositivo = (x) -> x > 0;
	static Predicate<Integer> _isNegativo = (x) -> x < 0;

	public static void main(String[] args) {

		Predicate<Integer> isPositivo = (x) -> x > 0;
		
		TestPred<Integer> tp = new TestPred<>();
		boolean b = tp.test(isPositivo, 3);
		System.out.println(b);
		
		//b = test(isNegativo, new Integer(3));
		
		new TestFun<Integer>().metodo(3);
	}

	public  boolean test(Predicate<T> p, T x) {
		boolean result = p.test(x);
		return result;
	}	
	
	public  void metodo(Integer y) {
		TestPred<Integer> tp = new TestPred<>();
		boolean b = tp.test(_isPositivo, 3);
		System.out.println(b);
	}

//	public  void metodo(Integer x) {
//		test(isNegativo, x);
//	}
	
}
