package com.semasahinbay.ecommerce.controller;

import com.semasahinbay.ecommerce.entity.Role;
import com.semasahinbay.ecommerce.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
@CrossOrigin("*")
public class RoleController {
    private RoleRepository roleRepository;
    @Autowired
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @GetMapping
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
