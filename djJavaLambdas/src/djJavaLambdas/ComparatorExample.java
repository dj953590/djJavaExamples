package djJavaLambdas;

import java.util.Comparator;

public class ComparatorExample {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	/** prior to java 8 */
	
	Comparator<Integer> c = new Comparator<Integer>() {

	    @Override
	    public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	    }
	    
	};
	
	System.out.println("Result of comparator prior to java 8 : " + c.compare(3, 2));
	
	/** In Java 8 Comparator is the functional interface 
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
	
	Comparator<Integer> c1 = (Integer o1, Integer o2) -> { return o1.compareTo(o2);};
	
	System.out.println("Result of comparator in java 8 with simple Lamda function : " + c1.compare(3, 2));
    }

}
