
public class ThreadBasic01 {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				throw new RuntimeException("Intenttional Exception");
			}
		});
		
		thread.setName("Misbehaved thread");
		/* We can set an exception handler for the entire thread at its inception.
		That handler will be called if an exception was thrown inside the thread and 
		did not get caught anywhere in this case.
		*/
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("A critical error happend in thread " + t.getName() + 
						" and the error is " + e.getMessage());
			}
		});
		thread.start();
	}
}
