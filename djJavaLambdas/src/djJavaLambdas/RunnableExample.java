/**
 * 
 */
package djJavaLambdas;

/**
 * @author dj153
 *
 */
public class RunnableExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	/** Prior Java 8  how the runnable interface is implemented*/
	
	Runnable runnable = new Runnable() {

	    @Override
	    public void run() {
		// TODO Auto-generated method stub
		System.out.println("Inside Runnable prior to java 8");
	    }
	};
	
	Thread t = new Thread (runnable);
	t.start();
	
	/** In Java 8 runnable is the functional interface 
	 * A functional interface is an interface that contains only one abstract method. 
	 * They can have only one functionality to exhibit. From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface. 
	 * A functional interface can have any number of default methods. Runnable, ActionListener, Comparable are some of the examples of functional interfaces. 
	 * Functional Interface is additionally recognized as Single Abstract Method Interfaces. In short, they are also known as SAM interfaces. 
	 * Functional interfaces in Java are the new feature that provides users with the approach of fundamental programming. 
	 * Functional interfaces are used and executed by representing the interface with an annotation called @FunctionalInterface. 
	 * As described earlier, functional interfaces can contain only one abstract method. However, they can include any quantity of default and static methods. 
	 * With Java 8 default method got added to the interfaces as way to add common implementation in the interface
	 * Below example changes the above code into one lambda expression
	 * */
	Runnable runLambda = () -> {System.out.println("Lmabda expression for Runnable Interface");}; 
	
	t = new Thread(runLambda);
	t.start();
		
    }

}
