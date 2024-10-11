package com.semasahinbay.ecommerce.dto;

public record OrderProductDto(Long productId,
                              int count,
                              String detail) {
}
