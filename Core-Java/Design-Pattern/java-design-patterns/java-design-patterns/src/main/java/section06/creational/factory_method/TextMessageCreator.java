package section06.creational.factory_method;

import section06.creational.factory_method.message.Message;
import section06.creational.factory_method.message.TextMessage;

/**
 * Provides implementation for creating Text messages
 */
public class TextMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}
