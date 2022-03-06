/**
 * 
 */
package djJavaLambdas;

import java.util.function.Function;

/**
 * @author djadhav
 * Function interface takes two object parameter 
 * first object is the input parameter
 * Second is the output parameter 
 * Here we have shown for String but it can be any objects
 *  
 *  */
public class FunctionExample {

	/**
	 * @param args
	 */
	
	static Function<String, String> fnt = (name) -> {return name.toUpperCase();};
	
	public static void main(String[] args) {
		
		System.out.println(fnt.apply("java8"));

	}

}
