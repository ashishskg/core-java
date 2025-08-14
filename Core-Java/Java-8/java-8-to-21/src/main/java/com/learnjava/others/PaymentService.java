package com.learnjava.others;

public class PaymentService {

    public PaymentResponse makePayment(OrderDetails orderDetails) {
        var paymentGateway = PaymentFactory.paymentGateway(orderDetails.card().cardType());
        return paymentGateway.makePayment(orderDetails.card(), orderDetails.finalAmount());
    }
}
