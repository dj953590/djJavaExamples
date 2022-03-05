/**
 * 
 */
package djJavaLambdas;

import java.util.function.Consumer;

/**
 * @author djadhav
 * Represents an operation that accepts a single input argument and returns no result. Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
   This is a functional interface whose functional method is accept(Object).
 */
public class ConsumerExample {
	
		
	
	public static void main(String[] args) {
	
		Consumer<String> c1 = (s)->{System.out.println(s);};
		c1.accept("This is Java8 programming");
		
	}
}
