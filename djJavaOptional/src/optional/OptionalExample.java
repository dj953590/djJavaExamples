/**
 * 
 */
package optional;

import java.util.Optional;

import Students.Student;
import Students.StudentDatabase;

/**
 * @author djadhav
 *
 */
public class OptionalExample {

	
	public static String getStudentName(){

        //Student student = StudentDataBase.studentSupplier.get();
        Student student = null;
        if(student!=null){
            return student.getName();
        }

        return null;
    }

    public static Optional<String> getStudentNameOptionalNull(){

        Optional<Student> studentOptional = Optional.ofNullable(null); // Optional.empty()
        if(studentOptional.isPresent()){
            studentOptional.get(); //Student
            return studentOptional.map(Student::getName); //Optional<String>
        }

        return Optional.empty(); // Represents an optional object with no value
    }
    
    public static Optional<String> getStudentNameOptional(){

        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
        if(studentOptional.isPresent()){
            return studentOptional.map(t -> t.getName()); //Optional<String>
        }

        return Optional.empty(); // Represents an optional object with no value
    }

    public static void main(String[] args) {

    	/** this is how you do in the old times */
        String name = getStudentName();
        
        if(name!=null)
            System.out.println("Length of the student Name : " + name.length());
        else
            System.out.println("Name not found");

        // use the optional to check how you can not do the null check
        
        Optional<String> stringOptional = getStudentNameOptional();

        if(stringOptional.isPresent()){
            System.out.println("Length of the student Name : " +
                    stringOptional.get().length()); //String which is Student Name
        }else{
            System.out.println("Name not found");
        }
        
        // how to create the null optional object and pass and check
        Optional<String> stringNullOptional = getStudentNameOptionalNull();

        if(stringNullOptional.isPresent()){
            System.out.println("Length of the student Name : " +
            		stringNullOptional.get().length()); //String which is Student Name
        }else{
            System.out.println("Name not found");
        }

    }

}
