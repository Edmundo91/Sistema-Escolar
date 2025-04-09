package com.sistemaescolar.dto;

import com.sistemaescolar.enums.AnosEnum;
import com.sistemaescolar.enums.CicloEnum;
import com.sistemaescolar.enums.PeriodoEnum;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class TurmaDTO {

	private String nome; 
	private AnosEnum anoLetivo; 
	private PeriodoEnum turno;
	private CicloEnum ciclo;
}
