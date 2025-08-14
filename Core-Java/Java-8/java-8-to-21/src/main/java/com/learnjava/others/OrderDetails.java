package com.learnjava.others;

public record OrderDetails(String orderId,

                           Card card,
                           double finalAmount) {
}
