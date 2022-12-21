package chatGPT;

public class MyClass {

	  // Static variable
	  public static int myStaticVariable = 0;

	  // Static method
	  public static void myStaticMethod() {
	    // Access static variable directly
	    myStaticVariable++;

	    // Call static method directly
	    myOtherStaticMethod();
	  }

	  // Another static method
	  public static void myOtherStaticMethod() {
	    // Do something...
	  }

	  // Non-static method
	  public void myInstanceMethod() {
	    // Do something...
	  }

	  // Main method
	  public static void main(String[] args) {
	    // Access static variable and method directly
	    myStaticVariable++;
	    myStaticMethod();
	    
	    //myInstanceMethod(); ERRORE

	    // Create instance of class and call non-static method
	    MyClass instance = new MyClass();
	    instance.myInstanceMethod();
	  }

	}

