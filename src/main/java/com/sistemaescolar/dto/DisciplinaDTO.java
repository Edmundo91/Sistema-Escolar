package com.sistemaescolar.dto;

import com.sistemaescolar.enums.CicloEnum;

import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
public class DisciplinaDTO {
    
	private String nome;
    
    private CicloEnum ciclo;

}
