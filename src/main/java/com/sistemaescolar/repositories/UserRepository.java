package com.sistemaescolar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sistemaescolar.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByNomeContainingIgnoreCase(String nome);
	
}
