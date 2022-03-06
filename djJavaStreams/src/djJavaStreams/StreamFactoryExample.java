/**
 * 
 */
package djJavaStreams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author djadhav The Stream interface factory methods are the methods that
 *         create a Stream object. Their implementation includes a call to a
 *         class constructor and that is the advantage of factory methods: they
 *         can do much more than a constructor. They can return any type as
 *         needed, not just the instance of the constructed class. They can
 *         control the number of instances, use a pool, re-use the instances,
 *         and similar. They can have different names even as they produce
 *         instances of the same type but constructed in a particular manner or
 *         with different parameters/values. The following are factory methods
 *         of the Stream interface: 
 *         static Stream<T> generate(Supplier<T> s);
 *         static Stream<T> iterate(T seed, UnaryOperator<T> f); 
 *         static Stream<T> iterate(T seed, Predicate<T> hasNext, UnaryOperator<T>next); 
 *         static Stream.Builder<T> builder(); 
 *         static Stream<T> of(T...values); 
 *         static Stream<T> empty(); static Stream<T> ofNullable(T t);
 *         static Stream<T> concat(Stream<T> a, Stream<T> b);
 *
 */
public class StreamFactoryExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stream<String> stringStream = Stream.of("Jim", "Valley", "Steve");
		//use ctrl+1 quick assists to check the actual consumer implementation
		stringStream.forEach(System.out::println);
		
		// how to use the iterator to generate and limit the iteration to 10 (otherwise it will create infinite number
		Stream.iterate(1, (Integer x)->{
			return x*2;
		})
		.limit(10)
		.forEach(System.out::println);
		
		// use supplier to generate list of random numbers and print
		Supplier<Integer> s = () -> new Random().nextInt();
		
		Stream.generate(s)
		.limit(5)
		.forEach(System.out::println);

	}

}
