package section31.behaviral.nullobject;

import section31.behaviral.nullobject.ComplexService;
import section31.behaviral.nullobject.NullStorageService;

public class Client {

	public static void main(String[] args) {
		ComplexService service = new ComplexService("Simple report 2",new NullStorageService());
		service.generateReport();
		
	}

}
