package section09.creational.singleton;

public class Client {

	public static void main(String[] args) {
		EagerRegistry registry = EagerRegistry.getInstance();
		EagerRegistry registry2 = EagerRegistry.getInstance();
		System.out.println(registry == registry2);

		LazyRegistryWithDCL lazyRegistryWithDCL = LazyRegistryWithDCL.getInstance();
		LazyRegistryWithDCL lazyRegistryWithDCL2 = LazyRegistryWithDCL.getInstance();

		System.out.println(lazyRegistryWithDCL == lazyRegistryWithDCL2);

		LazyRegistryIODH lazyRegistryIODH;
		lazyRegistryIODH = LazyRegistryIODH.getInstance();

		RegistryEnum registryEnum = RegistryEnum.INSTANCE;
		RegistryEnum registryEnum2 = RegistryEnum.INSTANCE;
		System.out.println(registryEnum == registryEnum2);
	}
}
