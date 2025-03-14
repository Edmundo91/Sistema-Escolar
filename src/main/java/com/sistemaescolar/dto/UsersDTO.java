package com.sistemaescolar.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.sistemaescolar.enums.RoleName;

import lombok.Getter;
import lombok.Setter;


@Getter	
@Setter
public class UsersDTO {

	private String nome; 
	private String email; 
	private String senha;
	private String dataNascimento; 
	private List<String> posto;
	


public List<RoleName> getPostoAsEnum() {
    return posto.stream()
        .map(role -> RoleName.valueOf(role.toUpperCase())) // Converte cada String para Enum
        .collect(Collectors.toList());
}



}