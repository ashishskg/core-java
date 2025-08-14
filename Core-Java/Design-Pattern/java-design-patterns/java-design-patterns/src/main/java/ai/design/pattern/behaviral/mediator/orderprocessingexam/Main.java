package ai.design.pattern.behaviral.mediator.orderprocessingexam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

// Mediator interface
interface OrderProcessingMediator {
    void processOrder(Order order);
    void updateInventory(Order order);
    void processPayment(Order order);
    void shipOrder(Order order);
    void sendNotification(Order order);
}

// Concrete mediator class
class OrderProcessingMediatorImpl implements OrderProcessingMediator {
    private InventoryManagementSystem inventorySystem;
    private PaymentGateway paymentGateway;
    private ShippingService shippingService;
    private NotificationService notificationService;

    public OrderProcessingMediatorImpl(InventoryManagementSystem inventorySystem, PaymentGateway paymentGateway,
                                       ShippingService shippingService, NotificationService notificationService) {
        this.inventorySystem = inventorySystem;
        this.paymentGateway = paymentGateway;
        this.shippingService = shippingService;
        this.notificationService = notificationService;
    }

    public void processOrder(Order order) {
        updateInventory(order);
        processPayment(order);
        shipOrder(order);
        sendNotification(order);
    }

    public void updateInventory(Order order) {
        inventorySystem.updateQuantity(order.getProduct(), order.getQuantity());
    }

    public void processPayment(Order order) {
        paymentGateway.processPayment(order.getTotalAmount());
    }

    public void shipOrder(Order order) {
        shippingService.ship(order.getAddress(), order.getProduct(), order.getQuantity());
    }

    public void sendNotification(Order order) {
        notificationService.sendNotification(order.getCustomer(), "Your order has been shipped!");
    }
}

// Inventory management system
class InventoryManagementSystem {
    public void updateQuantity(Product product, int quantity) {
        // Update inventory quantity
        System.out.println("Inventory updated for product: " + product.getName() + ", Quantity: " + quantity);
    }
}

// Payment gateway
class PaymentGateway {
    public void processPayment(double amount) {
        // Process payment
        System.out.println("Payment processed successfully. Amount: " + amount);
    }
}

// Shipping service
class ShippingService {
    public void ship(Address address, Product product, int quantity) {
        // Ship order
        System.out.println("Order shipped to: " + address.getStreet() + ", Product: " +
                product.getName() + ", Quantity: " + quantity);
    }
}

// Notification service
class NotificationService {
    public void sendNotification(Customer customer, String message) {
        // Send notification
        System.out.println("Notification sent to customer " + customer.getName() + ": " + message);
    }
}

// Order class
class Order {
    private Product product;
    private int quantity;
    private Address address;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private Customer customer;

    Order(Product product, int quantity, Address address, Customer customer) {
        this.product = product;
        this.quantity = quantity;
        this.address = address;
        this.customer = customer;
    }




    public double getTotalAmount() {
        return product.getPrice() * quantity;
    }
}

// Product class
@Data
class Product {
    private String name;
    private double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Constructor, getters, and setters
}

// Address class
@Data
@AllArgsConstructor
class Address {
    private String street;
    private String city;
    private String country;

    // Constructor, getters, and setters
}

// Customer class
@Data
@AllArgsConstructor
class Customer {
    private String name;

    // Constructor, getters, and setters
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create instances of the components
        InventoryManagementSystem inventorySystem = new InventoryManagementSystem();
        PaymentGateway paymentGateway = new PaymentGateway();
        ShippingService shippingService = new ShippingService();
        NotificationService notificationService = new NotificationService();

        // Create mediator and pass the components to it
        OrderProcessingMediator mediator = new OrderProcessingMediatorImpl(inventorySystem, paymentGateway,
                shippingService, notificationService);

        // Create an order
        Product product = new Product("Phone", 999.99);
        Address address = new Address("123 Street", "City", "Country");
        Customer customer = new Customer("John Doe");
        Order order = new Order(product, 2, address, customer);

        // Process the order
        mediator.processOrder(order);
    }
}
