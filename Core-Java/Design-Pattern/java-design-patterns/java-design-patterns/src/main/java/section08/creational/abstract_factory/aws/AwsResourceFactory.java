package section08.creational.abstract_factory.aws;

import section08.creational.abstract_factory.Instance;
import section08.creational.abstract_factory.ResourceFactory;
import section08.creational.abstract_factory.Storage;

//Factory implementation for Google cloud platform resources
public class AwsResourceFactory implements ResourceFactory {
    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new Ec2Instance(capacity);

    }

    @Override
    public Storage createStorage(int capMib) {
        return new S3Storage(capMib);
    }
}
