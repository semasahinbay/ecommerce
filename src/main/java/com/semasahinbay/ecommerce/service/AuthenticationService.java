package com.semasahinbay.ecommerce.service;

import com.semasahinbay.ecommerce.entity.ApplicationUser;
import com.semasahinbay.ecommerce.entity.Role;
import com.semasahinbay.ecommerce.entity.Store;
import com.semasahinbay.ecommerce.repository.RoleRepository;
import com.semasahinbay.ecommerce.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private StoreService storeService;

    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder,StoreService storeService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
         this.storeService = storeService;
    }

    public ApplicationUser register(String fullName, String email, String password, Long roleId, Store store) {
        String encodePassword = passwordEncoder.encode(password);

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));

        ApplicationUser user = new ApplicationUser();
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(encodePassword);
        user.setRole(role);

        if (role.getId() == 2 && store != null) {
            Store savedStore = storeService.saveStore(store);
            user.setStore(savedStore);
            savedStore.setUser(user);
        }


        return userRepository.save(user);
    }


}
