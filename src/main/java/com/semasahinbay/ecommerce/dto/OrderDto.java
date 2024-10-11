package com.semasahinbay.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(Long id,
                       LocalDateTime orderDate,
                       String cardHolderName,
                       String cardNumber,
                       String expirationDate,
                       double price,
                       Long userId,
                       AddressOrderResponseDto address,
                       List<ProductOrderResponseDto> products) {
}
