package com.sistemaescolar.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data 
@Entity
public class Turma {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL) 
    @MapsId
	@JoinColumn(name = "id") 
	private Ano ano;
	
	@OneToMany(mappedBy = "turma")
	private List<Aluno> alunos; 
	
	
	@OneToOne(cascade = CascadeType.ALL) 
    @MapsId
	@JoinColumn(name = "id") 
	private Periodo periodo; 

}
