
public class SynchronizedLockResourceShareTest {

	public static void main(String[] args) throws InterruptedException {

		InventoryCounter inventoryCounter = new InventoryCounter();

		IncrementThread incrementThread = new IncrementThread(inventoryCounter);
		DecrementThread decrementThread = new DecrementThread(inventoryCounter);

		incrementThread.start();

		decrementThread.start();
		incrementThread.join();
		decrementThread.join();

		System.out.println("Items = " + inventoryCounter.getItems());
	}

	private static class DecrementThread extends Thread {

		private InventoryCounter inventoryCounter;

		public DecrementThread(InventoryCounter inventoryCounter) {
			this.inventoryCounter = inventoryCounter;
		}

		public void run() {
			for (int i = 0; i <= 1000; i++) {
				inventoryCounter.decrement();
			}
		}
	}

	private static class IncrementThread extends Thread {

		private InventoryCounter inventoryCounter;

		public IncrementThread(InventoryCounter inventoryCounter) {
			this.inventoryCounter = inventoryCounter;
		}

		public void run() {
			for (int i = 0; i <= 1000; i++) {
				inventoryCounter.increment();
			}
		}
	}

	private static class InventoryCounter {

		private int items = 0;
		
		Object lock = new Object();

		public void increment() {
			synchronized(this.lock) {
				items++;
			}
		}

		public void decrement() {
			synchronized(this.lock) {
				items--;
			}	
		}

		public int getItems() {
			synchronized(this.lock) {
				return items;
			}	
		}
	}
}
