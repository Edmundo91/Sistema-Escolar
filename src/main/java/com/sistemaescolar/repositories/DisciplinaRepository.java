package com.sistemaescolar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.enums.CicloEnum;
import com.sistemaescolar.models.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{

	List<Disciplina> findByCiclo(CicloEnum ciclo);
	
}
