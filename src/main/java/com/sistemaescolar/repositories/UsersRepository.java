package com.sistemaescolar.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.models.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	List<Users> findByNomeContainingIgnoreCase(String nome);

	Users findByEmail(String email);
	
}
