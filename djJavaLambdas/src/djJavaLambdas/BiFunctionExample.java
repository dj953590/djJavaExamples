/**
 * 
 */
package djJavaLambdas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import Students.Student;
import Students.StudentDatabase;

/**
 * @author djadhav
 * BiFunction interface allows tow input objects and have to return other object type
 * lets take Students and Predicate as input and create a map
 */
public class BiFunctionExample {

	/**
	 * @param args
	 */
	static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> studentfunction = (students, p1) -> {
		Map<String, Double> StudentGrade = new HashMap();
		
		students.forEach((student -> {
			if (p1.test(student)) {
				StudentGrade.put(student.getName(), student.getGpa());
			}
		}));
	return StudentGrade;
	};
	
	public static void main(String[] args) {

		System.out.println("Grades : " + studentfunction.apply(StudentDatabase.getAllStudents(), PredicateStudentExample.p1));
		
		System.out.println("GPA : " + studentfunction.apply(StudentDatabase.getAllStudents(), PredicateStudentExample.p2));
	}

}
