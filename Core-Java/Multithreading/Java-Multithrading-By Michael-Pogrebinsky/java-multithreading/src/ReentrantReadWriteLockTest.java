import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

	public static void main(String[] args) {
		ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
		Lock readLock = rwLock.readLock();
		Lock writeLock = rwLock.writeLock();
		
		/*
		 We use the write lock to log access to critical section 
		 where the thread is modifying the shared resource. 
		 * */
		writeLock.lock();
		try {
			// modifySharedResources();
		} finally {
			writeLock.unlock();
		}
		
		/*
		 If we only want to read from a shared resources we use the read lock to guard
		 the critical section and unlock it after we are done. 
		 
		 Multiple threads can acquire the read lock simultaneously. In other words, 
		 many reading threads are allowed to get into the critical section 
		 guarded by the read lock. The read lock internally keeps the count of how many
		 reader threads are holding it at a given moment.
		 
		 Only a single thread is allowed to lock a write lock, 
		 * */
		readLock.lock();
		try {
			// readFromSharedResources();
		} finally {
			readLock.unlock();
		}
	}
}
