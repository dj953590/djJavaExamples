/**
 * 
 */
package djJavaLambdas;

import java.util.List;
import java.util.function.Consumer;

import Students.Student;
import Students.StudentDatabase;

/**
 * @author djadhav
 * Represents an operation that accepts a single input argument and returns no result. Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
   This is a functional interface whose functional method is accept(Object).
 */
public class ConsumerExample {
	
	static Consumer<Student> c2 = (student) -> {System.out.println(student);};
	
	static Consumer<Student> c3 = (student) -> {System.out.print(student.getName());};
	
	static Consumer<Student> c4 = (student) -> {System.out.println(student.getActivities());};
	
	public static void printAllStudents() {
		List<Student> allStudents = StudentDatabase.getAllStudents();
		allStudents.forEach(c2);
	}
	
	public static void printNameAndActivities() {
		System.out.println("\nPrint just Name and Activities");
		List<Student> allStudents = StudentDatabase.getAllStudents();
		
		// on each of the student in the for each class do following activity
		//and then allows them to add the two operation on student class
		allStudents.forEach(c3.andThen(c4));
	}
	
	public static void printNameAndActivitiesUsingConditions() {
		System.out.println("\nPrint just Name and Activities Based on Conditions");
		List<Student> allStudents = StudentDatabase.getAllStudents();
		allStudents.forEach(((student) -> {
			
			if (student.getGradeLevel() >=3 && student.getGpa() >= 3.9) {
				c3.andThen(c4).accept(student);
			}
		}));
	}
		
	
	
	public static void main(String[] args) {
	
		Consumer<String> c1 = (s)->{System.out.println(s);};
		c1.accept("This is Java8 programming");
		
		printAllStudents();
		
		printNameAndActivities();
		
		printNameAndActivitiesUsingConditions();
	}
}
