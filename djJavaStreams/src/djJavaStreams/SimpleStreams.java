package djJavaStreams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Students.Student;
import Students.StudentDatabase;

/**
 *  @author djadhav 
 *  	   Stream is used to process the collections of the objects. A
 *         Stream us a sequence of objects that supports various methods which
 *         can be pipelined to produce desired result The features of Java
 *         stream are –
 * 
 *         A stream is not a data structure instead it takes input from the
 *         Collections, Arrays or I/O channels. 
 *         Streams don’t change the original data structure, they only provide the result as per the
 *         pipelined methods. Each intermediate operation is lazily executed and
 *         returns a stream as a result, hence various intermediate operations
 *         can be pipelined. 
 *         Terminal operations mark the end of the stream and return the result. 
 *         Different Operations On Streams- Intermediate Operations:
 * 
 *         map: The map method is used to returns a stream consisting of the
 *         results of applying the given function to the elements of this
 *         stream. List number = Arrays.asList(2,3,4,5); List square =
 *         number.stream().map(x->x*x).collect(Collectors.toList()); 
 *         
 *         filter: The filter method is used to select elements as per the Predicate passed
 *         as argument. List names =
 *         Arrays.asList("Reflection","Collection","Stream"); List result =
 *         names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
 *         
 *         sorted: The sorted method is used to sort the stream. List names =
 *         Arrays.asList("Reflection","Collection","Stream"); List result =
 *         names.stream().sorted().collect(Collectors.toList()); Terminal
 *         Operations:
 * 
 *         collect: The collect method is used to return the result of the
 *         intermediate operations performed on the stream. List number =
 *         Arrays.asList(2,3,4,5,3); Set square =
 *         number.stream().map(x->x*x).collect(Collectors.toSet());
 *          
 *         forEach: The forEach method is used to iterate through every element of the
 *         stream. List number = Arrays.asList(2,3,4,5);
 *         number.stream().map(x->x*x).forEach(y->System.out.println(y));
 *         
 *         reduce: The reduce method is used to reduce the elements of a stream
 *         to a single value. The reduce method takes a BinaryOperator as a
 *         parameter. List number = Arrays.asList(2,3,4,5); int even =
 *         number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
 */

public class SimpleStreams {
	
	static Predicate<Student> p1 = (student) -> {return student.getGradeLevel() >= 3;};
	static Predicate<Student> p2 = (student -> student.getGpa() >= 3.9);
	
	public static void main(String[] args) {
		
		Map<String, List<String>> studentMap = StudentDatabase.getAllStudents().stream()
				.filter(p1)
				.filter(p2)
				.collect(Collectors.toMap(Student::getName, Student::getActivities));
		
		System.out.println(studentMap);
	}

}
