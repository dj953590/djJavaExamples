/**
 * 
 */
package djJavaLambdas;

import java.util.function.Function;

/**
 * @author djadhav
 * Function interface takes one object parameter and return other other 
 */
public class FunctionExample {

	/**
	 * @param args
	 */
	
	static Function<String, String> fnt = (name) -> {return name.toUpperCase();};
	
	public static void main(String[] args) {
		
		System.out.println(fnt.apply("java8"));

	}

}
