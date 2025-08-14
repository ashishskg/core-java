package ai.design.pattern.behaviral.mediator.chatexam;

import java.util.ArrayList;
import java.util.List;

// Mediator interface
interface ChatMediator {
    void sendMessage(User user, String message);
    void addUser(User user);
}

// Concrete mediator class
class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    public void sendMessage(User user, String message) {
        for (User u : users) {
            if (u != user) {
                u.receiveMessage(user.getName(), message);
            }
        }
    }

    public void addUser(User user) {
        users.add(user);
    }
}

// Colleague interface
interface User {
    void sendMessage(String message);
    void receiveMessage(String sender, String message);
    String getName();
}

// Concrete colleague class
class ChatUser implements User {
    private ChatMediator mediator;
    private String name;

    public ChatUser(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(this, message);
    }

    public void receiveMessage(String sender, String message) {
        System.out.println("[" + name + "] Message received from " + sender + ": " + message);
    }

    public String getName() {
        return name;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new ChatUser(mediator, "John");
        User user2 = new ChatUser(mediator, "Alice");
        User user3 = new ChatUser(mediator, "Bob");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user1.sendMessage("Hello everyone!"); // Broadcasts the message to all users
        user2.sendMessage("Hi John!"); // Only John receives this message
    }
}
