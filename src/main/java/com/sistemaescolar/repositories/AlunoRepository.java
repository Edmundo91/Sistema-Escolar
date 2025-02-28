package com.sistemaescolar.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.models.Aluno;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	List<Aluno> findByNomeContainingIgnoreCase(String nome);

	
}
