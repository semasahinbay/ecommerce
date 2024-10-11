package com.semasahinbay.ecommerce.dto;

public record PaymentDto(Long id,
                         String cardHolder,
                         String cardNumber,
                         String expirationDate,
                         Long userId) {
}

