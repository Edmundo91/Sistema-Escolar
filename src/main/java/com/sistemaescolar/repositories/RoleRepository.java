package com.sistemaescolar.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaescolar.enums.RoleName;
import com.sistemaescolar.models.Role;

public interface RoleRepository extends JpaRepository <Role, Long>{

	
Optional<Role> findByName(RoleName role);
	
}
