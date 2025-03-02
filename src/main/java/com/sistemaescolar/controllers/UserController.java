package com.sistemaescolar.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaescolar.models.Users;
import com.sistemaescolar.services.UsersService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
 private UsersService service;
	

 @PostMapping("/save")
 public Users registrarUser(Users user) { 
	 
	return service.SalvarUser(user); 
	 
 }
 
 
 @GetMapping("/{id}")
 public Users buscarUserPorId(Long id) { 
	 
	 return service.buscarUserPorId(id);
	 
 }
	
 
 
@GetMapping("/busca")    
public List<Users> buscarUserPorNome(String nome){ 
		
	return service.buscarUserPorNome(nome);
				
	}
 
 @DeleteMapping("/{id}")
 public void deletarUser(Long id) { 
	 
     service.DeleteUser(id);	 
	 
 }
 
	
}
