package com.sistemaescolar.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.models.Aluno;
import com.sistemaescolar.models.Ano;
import com.sistemaescolar.models.Periodo;
import com.sistemaescolar.models.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

  List<Turma> findByAnoContainingIgnoreCase(Ano ano);
	
  List<Turma> findByPeriodoContainingIgnoreCase(Periodo periodo);
 
  List<Aluno> findByNomeContainingIgnoreCase(String nome);
  


}
