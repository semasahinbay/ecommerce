package com.semasahinbay.ecommerce.repository;

import com.semasahinbay.ecommerce.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
    @Query("SELECT u FROM ApplicationUser u WHERE u.email = :email")
    Optional<ApplicationUser> findByEmail(String email);

}
