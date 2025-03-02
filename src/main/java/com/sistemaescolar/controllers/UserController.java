package com.sistemaescolar.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaescolar.models.User;
import com.sistemaescolar.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
 private UserService service;
	

 @PostMapping("/save")
 public User registrarUser(User user) { 
	 
	return service.SalvarUser(user); 
	 
 }
 
 
 @GetMapping("/{id}")
 public User buscarUserPorId(Long id) { 
	 
	 return service.buscarUserPorId(id);
	 
 }
	
 
 
@GetMapping("/busca")    
public List<User> buscarUserPorNome(String nome){ 
		
	return service.buscarUserPorNome(nome);
				
	}
 
 @DeleteMapping("/{id}")
 public void deletarUser(Long id) { 
	 
     service.DeleteUser(id);	 
	 
 }
 
	
}
