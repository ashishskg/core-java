
public class ThreadInterrupt01 {

	public static void main(String[] args) {
		Thread thread = new Thread(new BlockingTask());
		thread.start();
		// Stop the blocking thread
		thread.interrupt();
	}
	
	private static class BlockingTask implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(500000);
			} catch (InterruptedException e) {
				System.out.println("Exiting Blocking Queue");
			}
		}
		
	}
}