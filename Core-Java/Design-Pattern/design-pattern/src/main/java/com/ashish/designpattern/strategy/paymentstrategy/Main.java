package com.ashish.designpattern.strategy.paymentstrategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay with credit card
        cart.setPaymentStrategy(new CreditCardPaymentStrategy("1234567890123456", "12/23", "123"));
        cart.checkout(100);

        // Pay with PayPal
        cart.setPaymentStrategy(new PayPalPaymentStrategy("example@example.com", "password"));
        cart.checkout(200);
    }
}
