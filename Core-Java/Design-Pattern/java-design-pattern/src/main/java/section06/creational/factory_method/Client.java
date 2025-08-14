package section06.creational.factory_method;

import section06.creational.factory_method.message.Message;

public class Client {

	public static void main(String[] args) {
		printMessage(new JSONMessageCreator());

		printMessage(new TextMessageCreator());
	}
	
	public static void printMessage(MessageCreator creator) {
		Message msg = creator.getMessage();
		System.out.println(msg);
	}
}
