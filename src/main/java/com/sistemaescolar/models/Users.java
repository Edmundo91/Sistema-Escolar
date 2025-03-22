package com.sistemaescolar.models;

import jakarta.persistence.JoinColumn;

import java.time.LocalDate;

import java.util.List;

import com.sistemaescolar.exceptions.CpfInvalidException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data 
@Entity
public class Users {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;
	
	private String senha; 
	
	private String nome;  
	
	private String cpf; 
	
	private String endereco;
	
	private LocalDate dataNascimento;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="users_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> cargo;
	
	
	
	public void setCpfFormat(String cpf) {
	    if (cpf != null && cpf.length() == 11) {
	        this.cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
	    } else {
	        throw new CpfInvalidException();
	    }
	}
	
	
	
	
	
	
}
