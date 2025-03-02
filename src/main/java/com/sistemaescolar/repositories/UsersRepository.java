package com.sistemaescolar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import com.sistemaescolar.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	List<Users> findByNomeContainingIgnoreCase(String nome);
	
}
