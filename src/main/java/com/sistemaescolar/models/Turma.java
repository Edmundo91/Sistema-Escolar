package com.sistemaescolar.models;
import jakarta.persistence.ForeignKey;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sistemaescolar.enums.CicloEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

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
	@JoinColumn(name = "ano_id", foreignKey = @ForeignKey(name = "fk_turma_ano")) 
	private Ano ano;
	
	@Enumerated(EnumType.STRING)
	@JsonBackReference
	private CicloEnum ciclo;
	
	@OneToMany(mappedBy = "turma")
	@JsonBackReference
	private List<Aluno> alunos; 
	
	
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "periodo_id", foreignKey = @ForeignKey(name = "fk_turma_periodo")) 
	private Periodo periodo; 

} 
