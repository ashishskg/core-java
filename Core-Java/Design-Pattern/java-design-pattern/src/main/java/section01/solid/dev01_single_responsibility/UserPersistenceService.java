package section01.solid.dev01_single_responsibility;

//A separate class for handling persistence 
public class UserPersistenceService {

	private Store store = new Store();
	
	public void saveUser(User user) {
		store.store(user);
	}
}
