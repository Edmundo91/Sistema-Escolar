package com.sistemaescolar.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sistemaescolar.enums.RoleName;
import com.sistemaescolar.models.Role;
import com.sistemaescolar.repositories.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(RoleName.values()).forEach(roleName -> {
            if (!roleRepository.findByName(roleName).isPresent()) {
                Role role = new Role();
                role.setName(roleName);
                roleRepository.save(role);
                System.out.println("Role criada: " + roleName);
            } else {
                System.out.println("Role já existe: " + roleName);
            }
        });
    }
}
