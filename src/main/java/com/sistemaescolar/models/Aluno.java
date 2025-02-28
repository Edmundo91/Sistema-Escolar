package com.sistemaescolar.models;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data 
@Entity 
public class Aluno {
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;	
	
private String nome; 

private LocalDate dataNascimento;

@ManyToOne
@JoinColumn(name = "turma_id") 
private Turma turma; 

private byte[] foto;

public int getIdade() {
    if (this.dataNascimento == null) {
        return 0;
    }
    return Period.between(this.dataNascimento, LocalDate.now()).getYears();
}

}