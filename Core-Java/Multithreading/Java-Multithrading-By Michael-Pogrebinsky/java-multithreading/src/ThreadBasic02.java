
public class ThreadBasic02 {

	public static void main(String[] args) {
		Thread myThread = new MyThread();
		myThread.start();
	}
}
class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Using static method, Hello From " + Thread.currentThread().getName());
		System.out.println("Using this reference, Hello From " + this.getName());
	}
}
