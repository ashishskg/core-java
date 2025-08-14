import java.util.concurrent.locks.ReentrantLock;

public class ReetnrantLockTest {
	
	public static void main(String[] args) {
		CriticalOperation criticalOperation = new CriticalOperation();
		
		Thread thread = new Thread(criticalOperation);
		thread.start();
	}

	public static class CriticalOperation implements Runnable {
	    private ReentrantLock lock = new ReentrantLock();
	    /// other shared variables
	 
	    @Override
	    public void run() {
	    	try {
		        lock.lock();
		        someOperation();
			} finally {
				lock.unlock();
				System.out.println("Lock released");
			}
	    }
	 
	    private void someOperation() {
	    	System.out.println("ReetnrantLockTest.CriticalOperation.someOperation()");
	    	throw new RuntimeException();
	        //May throw a RuntimeException
	    }
	}
}