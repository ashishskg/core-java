package uncaughtexceptionhandler;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandlerApp implements UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status: %s\n", t.getState());
	}

	public static void main(String[] args) {
		new Thread(new Task()).start();
	}
}
