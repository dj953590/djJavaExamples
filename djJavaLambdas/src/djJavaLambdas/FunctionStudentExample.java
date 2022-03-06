package djJavaLambdas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import Students.Student;
import Students.StudentDatabase;

/**
 * 
 * @author djadhav
 * its takes the list of Student and returns the map of student and grade
 */
public class FunctionStudentExample {
	
	static Function<List<Student>, Map<String, Double>> studentfunction = (students) -> {
		Map<String, Double> StudentGrade = new HashMap();
		
		students.forEach((student -> {
			if (PredicateStudentExample.p1.test(student)) {
				StudentGrade.put(student.getName(), student.getGpa());
			}
		}));
	return StudentGrade;
	};

	public static void main(String[] args) {
		
		System.out.println(studentfunction.apply(StudentDatabase.getAllStudents()));
	}

}
