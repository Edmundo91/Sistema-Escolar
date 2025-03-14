package com.sistemaescolar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaescolar.dto.UsersDTO;
import com.sistemaescolar.models.Users;
import com.sistemaescolar.services.UsersService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
 
	@Autowired
	private UsersService service;
	

 //Registrar um user
 @PostMapping("/save")
 public Users registrarUser(@RequestBody UsersDTO userDTO) { 
	 
	return service.SalvarUser(userDTO); 
	 
 }
 
 
 //buscar user por id
 @GetMapping("/{id}")
 public Users buscarUserPorId(@PathVariable Long id) { 
	 
	 return service.buscarUserPorId(id);
	 
 }
	
 
 //buscar um user por nome
@GetMapping("/busca")    
public List<Users> buscarUserPorNome(@RequestParam String nome){ 
		
	return service.buscarUserPorNome(nome);
				
	}
 
 
//deletar user por id
@DeleteMapping("/{id}")
 public void deletarUser(@PathVariable Long id) { 
	 
     service.DeleteUser(id);	 
	 
 }
 
	
}
