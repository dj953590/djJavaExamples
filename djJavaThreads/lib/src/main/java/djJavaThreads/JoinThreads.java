/**
 * 
 */
package djJavaThreads;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dj153 Example demonstrates the join method and how to use it Create
 *         Factorial Thread Class then have the ArrayList of numbers and use
 *         threads and Thread join to calculate the factorial in the main
 */
public class JoinThreads {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {

	List<Long> inputNumbers = Arrays.asList(0L, 234L, 3456L, 45234L, 2345L, 4534L, 5556L);

	List<FactorialThread> threads = new ArrayList<JoinThreads.FactorialThread>();

	for (long inputNumber : inputNumbers) {
	    threads.add(new FactorialThread(inputNumber));
	}

	// Calculating the factorial
	for (Thread thread : threads) {
	    thread.start();
	}
	/**
	 * This  code when enables will join the main thread with each f the  factorial thread and make sure main thread
	 * waits for the all the factorial thread  to finish before terminates
	 */
	for (Thread thread : threads) {
	    thread.join();
	}
	
	// Getting the results

	for (int i = 0; i < inputNumbers.size(); i++) {

	    FactorialThread t = threads.get(i);
	    if (t.isFinished) {
		System.out.println(" Factoring off : " + inputNumbers.get(i) + " is " + t.getResult());
	    } else {
		System.out.println("The Calculation for " + inputNumbers.get(i) + "is still in progress");
	    }
	}
    }

    public static class FactorialThread extends Thread {

	private long inputNumber;
	private BigInteger result = BigInteger.ZERO;
	private boolean isFinished = false;

	public FactorialThread(long inputNumber) {
	    super();
	    this.inputNumber = inputNumber;
	}

	@Override
	public void run() {
	    // TODO Auto-generated method stub
	    super.run();
	    this.result = factorial(this.inputNumber);
	    this.isFinished = true;
	}

	private BigInteger factorial(long inputNumber) {

	    BigInteger tResults = BigInteger.ONE;

	    for (long i = 1; i <= inputNumber; i++) {
		tResults = tResults.multiply(new BigInteger(Long.toString(inputNumber)));
	    }

	    return tResults;
	}

	public boolean isFinished() {
	    return isFinished;
	}

	public BigInteger getResult() {
	    return result;
	}

    }
}
