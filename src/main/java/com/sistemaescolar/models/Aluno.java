package com.sistemaescolar.models;

import java.time.LocalDate;
import java.time.Period;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sistemaescolar.exceptions.CpfInvalidException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Data 
@Entity 
public class Aluno {
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;	
	
private String nome; 

private LocalDate dataNascimento;

private String cpf; 

private String endereco; 

@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
@JoinColumn(name = "boletim_id")
@JsonManagedReference
private Boletim boletim;
 
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

public void setCpfFormat(String cpf) {
    if (cpf != null && cpf.length() == 11) {
        this.cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    } else {
        throw new CpfInvalidException();
    }
}







}