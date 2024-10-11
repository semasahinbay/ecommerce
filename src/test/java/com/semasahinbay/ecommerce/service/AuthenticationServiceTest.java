package com.semasahinbay.ecommerce.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.semasahinbay.ecommerce.dto.RegisterUserDto;
import com.semasahinbay.ecommerce.entity.ApplicationUser;
import com.semasahinbay.ecommerce.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

class AuthenticationServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthenticationService authenticationService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loginUser_shouldReturnToken() {

        RegisterUserDto userDto = new RegisterUserDto("user1", "user1@example.com", "password", 1L, null);
        ApplicationUser user = new ApplicationUser(1L, "user1", "user1@example.com", "encodedPassword");

        when(userRepository.findByEmail(userDto.email())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);

        ApplicationUser registeredUser = authenticationService.register(userDto.fullName(), userDto.email(), userDto.password(), userDto.roleId(), userDto.store());

        assertNotNull(registeredUser);
        assertEquals("user1@example.com", registeredUser.getEmail());
    }
}