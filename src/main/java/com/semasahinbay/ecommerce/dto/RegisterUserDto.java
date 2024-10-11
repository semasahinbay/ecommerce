package com.semasahinbay.ecommerce.dto;

import com.semasahinbay.ecommerce.entity.Store;

public record RegisterUserDto(String fullName,
                              String email,
                              String password,
                              Long roleId,
                              Store store) {

    public String getUsername() {return this.email;
    }
}
