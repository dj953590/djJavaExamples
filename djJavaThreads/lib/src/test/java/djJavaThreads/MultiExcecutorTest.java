/**
 * 
 */
package djJavaThreads;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author djadhav
 *
 */
public class MultiExcecutorTest {
	@Test
	void MultiExecutoTest() {
		class task implements Runnable {
			@Override
			public void run() {
				System.out.println("My new thread : " + Thread.currentThread());
			}
		}
		
		List<Runnable> tasks = new ArrayList<Runnable>();
		
		int i = 10;
		for (int j = 0; j < i; j++) {
			tasks.add(new task());
		}
		MultiExecutor classUnderTest = new MultiExecutor(tasks);
		classUnderTest.executeAll();
	}
}


