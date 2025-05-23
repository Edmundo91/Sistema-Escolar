package com.sistemaescolar.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sistemaescolar.enums.CicloEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Definindo a chave primária
    private Long id; 
	
	
	String nome; 
	
	@Enumerated(EnumType.STRING)
	private CicloEnum ciclo;
	
	@ManyToOne
    @JoinColumn(name = "boletim_id")
	@JsonBackReference
	private Boletim boletim;
	double nota1; 
	double nota2;
}
