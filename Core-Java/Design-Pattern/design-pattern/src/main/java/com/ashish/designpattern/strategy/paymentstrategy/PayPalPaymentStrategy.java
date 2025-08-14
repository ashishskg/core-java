package com.ashish.designpattern.strategy.paymentstrategy;

class PayPalPaymentStrategy implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPaymentStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using PayPal account " + email);
    }
}

