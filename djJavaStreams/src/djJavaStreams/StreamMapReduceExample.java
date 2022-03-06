/**
 *
 */
package djJavaStreams;

import Students.Student;
import Students.StudentDatabase;

/**
 * @author djadhav How to use Map and Terminal method reduce
 */
public class StreamMapReduceExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int TotalNoteBooks = StudentDatabase.getAllStudentsWithNoteBooks().stream()
				.map(Student::getNotebooks)
				.reduce(0, (a, b) -> {
					return a + b;
				});
		System.out.print(TotalNoteBooks);
	}

}
