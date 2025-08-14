package section31.behaviral.nullobject;

import section31.behaviral.nullobject.Report;
import section31.behaviral.nullobject.StorageService;

public class NullStorageService extends StorageService {

	@Override
	public void save(Report report) {
		System.out.println("Null object save method. Doing nothing");
	}

	
}
