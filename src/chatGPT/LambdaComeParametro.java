package chatGPT;

//To pass a lambda expression as a parameter to a method, you can use a functional interface
//as the type of the method's parameter. A functional interface is an interface that contains
//only one abstract method. This means that any lambda expression that has the same signature 
//as the abstract method in the functional interface can be assigned to a variable of that 
//functional interface type.
//Here is an example of passing a lambda expression as a parameter to a method:
//	
//In this example, the performOperation() method takes a MyFunctionalInterface object as a parameter, 
//which allows it to accept a lambda expression that has the same signature as the abstract method in 
//the MyFunctionalInterface interface.
//
//The main() method creates a lambda expression that adds two numbers and assigns it to a variable of 
//the MyFunctionalInterface type. This lambda expression can then be passed as a parameter to the 
//performOperation() method, which calls the operate() method in the MyFunctionalInterface interface 
//using the lambda expression as the implementation.	

public class LambdaComeParametro {

		  // Functional interface
		  @FunctionalInterface
		  interface MyFunctionalInterface {
		    int operate(int a, int b);
		  }

		  // Method that takes a functional interface as a parameter
		  public static int performOperation(MyFunctionalInterface operation, int a, int b) {
		    // Call the abstract method in the functional interface and return the result
		    return operation.operate(a, b);
		  }

		  public static void main(String[] args) {
		    // Create lambda expression and assign it to a variable of the functional interface type
		    MyFunctionalInterface add = (int a, int b) -> a + b;

		    // Call the method and pass the lambda expression as a parameter
		    int result = performOperation(add, 5, 3);

		    // Print the result
		    System.out.println(result);  // Output: 8
		  }

		}
