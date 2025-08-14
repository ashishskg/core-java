import java.util.concurrent.atomic.AtomicReference;

public class CompareAndSetTest {

	public static void main(String[] args) {
		String oldName = "old name";
		String newName = "new name";
		AtomicReference<String> atomicReference = new AtomicReference<String>();
		
		// atomicReference.set("other name");
		atomicReference.set("old name");
		if(atomicReference.compareAndSet(oldName, newName)) {
			System.out.println("New value is : " + atomicReference.get());
		}
		else {
			System.out.println("Nothing changed!");
		}
	}
}
