package com.learnjava.others;

public record Card(String name,
                   String cardNumber,
                   String verificationCode,
                   String expiryDate,
                   CardType cardType
) {
}
