package section06.creational.factory_method;

import section06.creational.factory_method.message.JSONMessage;
import section06.creational.factory_method.message.Message;

/**
 * Provides implementation for creating JSON messages
 */
public class JSONMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}
