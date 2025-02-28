package com.sistemaescolar.models;

import com.sistemaescolar.enums.PeriodoEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Periodo {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Enumerated(EnumType.STRING)
	private PeriodoEnum periodo; 
	
}
