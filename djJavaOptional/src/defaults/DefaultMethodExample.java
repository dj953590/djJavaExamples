package defaults;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import Students.Student;
import Students.StudentDatabase;

public class DefaultMethodExample {

	public static Consumer<Student> c = student -> System.out.println(student.getName());
	public static Function<Student, String> f = s -> s.getName();  
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> stringList = Arrays.asList("Jim", "Adam", "Steve");
		stringList.sort(Comparator.naturalOrder());
		System.out.println(stringList);
		stringList.sort(Comparator.reverseOrder());
		System.out.println(stringList);
		
		// using the comparator for the student database
		List<Student> studentList = StudentDatabase.getAllStudents();
		System.out.println("Before Sort");
		studentList.forEach(c);
		System.out.println("After Sort");
		Comparator<Student> basedOnName = Comparator.comparing(f);
		studentList.sort(basedOnName);
		studentList.forEach(c);
	}
}
