package djJavaLambdas;

import java.util.List;
import java.util.function.Predicate;

import Students.Student;
import Students.StudentDatabase;

/**
 * Represents a predicate (boolean-valued function) of one argument.
 * 
 * @author djadhav
 * 
 *
 */
public class PredicateStudentExample {

	/**
	 * Define 2 predicate to check the GradeLevel and the GPA
	 */
	static Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;

    static Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;

    /** 
     * Filter the student based on Grade level
     */
    public static void filterStudentsByGradeLevel(){

        System.out.println("filterStudentsByGradeLevel :");

        List<Student> studentList = StudentDatabase.getAllStudents();

        studentList.forEach((student -> {
        	// here we call the test method to initial the lambda function implementation
            if(p1.test(student)){
                System.out.println(student);
            }
        }));
    }

    /**
     * filer the students based on GPA
     */
    public static void filterStudentsByGpa(){

        System.out.println("filterStudentsByGpa :");
        List<Student> studentList = StudentDatabase.getAllStudents();

        studentList.forEach((student -> {

            if(p2.test(student)){
                System.out.println(student);
            }
        }));
    }

    /**
     * use the or condition to do the filter of the student
     */
    public static void filterStudents(){

        System.out.println("filterStudents :");
        List<Student> studentList = StudentDatabase.getAllStudents();

        studentList.forEach((student -> {
        	// the p1 and p2 are 2 different conditions which are getting evaluated using the or
        	if(p1.or(p2).test(student)){
                System.out.println(student);
            }else{
                System.out.println(student);
            }
        }));
    }
    
	public static void main(String[] args) {
		// Simple Predicate Example
		Predicate<Integer> iseven = (i) -> {return i%2==0;};
		System.out.println(iseven.test(10));
		
		filterStudentsByGradeLevel();
		
		filterStudentsByGpa();
		
		filterStudents();
		
	}

}
