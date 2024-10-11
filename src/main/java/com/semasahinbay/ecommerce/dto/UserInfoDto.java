package com.semasahinbay.ecommerce.dto;

import java.util.List;

public record UserInfoDto(Long id, String fullName, String email,
                          List<AddressDto> addresses) {
}

