package com.sistemaescolar.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity 
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Boletim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	
	@OneToOne(mappedBy = "boletim")
	@JsonBackReference
	private Aluno aluno;
	
	@OneToMany(mappedBy = "boletim",  cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Disciplina> disciplinas; 
}
