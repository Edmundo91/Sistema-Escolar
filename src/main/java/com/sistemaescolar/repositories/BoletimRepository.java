package com.sistemaescolar.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.enums.CicloEnum;
import com.sistemaescolar.models.Boletim;


@Repository
public interface BoletimRepository extends  JpaRepository<Boletim, Long>{

	Optional<Boletim> findByCiclo(CicloEnum ciclo);
    
   
}
