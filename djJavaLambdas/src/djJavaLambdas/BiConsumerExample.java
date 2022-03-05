/**
 * 
 */
package djJavaLambdas;

import java.util.List;
import java.util.function.BiConsumer;

import Students.Student;
import Students.StudentDatabase;

/**
 * @author djadhav
 *
 */
public class BiConsumerExample {

	/**
	 * @param args
	 */
	/**
	 * use the student database and print the names and activities
	 * 
	 */
	public static void printNameAndActivities() {
		
		BiConsumer<String, List<String>> biConsumer = (name, activities) -> {
			System.out.println(name + " : " + activities);
		};
		
		List<Student> all = StudentDatabase.getAllStudents();
		
		all.forEach((student) -> {biConsumer.accept(student.getName(), student.getActivities());});
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BiConsumer<String , String> biConsumer = (a,b) -> { System.out.println("a: " + a + " b: " + b);};
		biConsumer.accept("Go to " , "java 8");
		
		printNameAndActivities();

	}

}
