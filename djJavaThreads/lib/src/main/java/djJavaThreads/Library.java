/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package djJavaThreads;

public class Library {
    
    public boolean someLibraryMethod() {
	
	Thread mnew = new myThread();
	mnew.setName("My first Thread Class");
	mnew.start();
	
	return true;
    }
    
    private static class myThread extends Thread {
	@Override
	public void run() {
	    System.out.println ("Hello from : " + Thread.currentThread());
	}
    }
}