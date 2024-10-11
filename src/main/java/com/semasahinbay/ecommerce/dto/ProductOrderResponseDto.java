package com.semasahinbay.ecommerce.dto;

public record ProductOrderResponseDto(
        Long id,
        String name,
        double price,
        String image) {
}
