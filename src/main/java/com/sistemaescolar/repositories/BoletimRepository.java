package com.sistemaescolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.models.Boletim;

@Repository
public interface BoletimRepository extends  JpaRepository<Boletim, Long>{


}
