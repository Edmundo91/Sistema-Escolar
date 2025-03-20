package com.sistemaescolar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import com.sistemaescolar.dto.AuthenticationDTO;
import com.sistemaescolar.dto.TokenDTO;

import com.sistemaescolar.security.TokenService;
import com.sistemaescolar.security.UserDetailsImpl;

@RestController 
@RequestMapping(value = "/auth")
public class AuthenticationController {

	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity<TokenDTO> login (@RequestBody AuthenticationDTO data) { 
		
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getSenha()); 
		
		var auth = this.authenticationManager.authenticate(usernamePassword);
	
		var userDetails = (UserDetailsImpl) auth.getPrincipal();
		
		var token = tokenService.generateToken(userDetails.getUser());
		
		return ResponseEntity.ok(new TokenDTO(token));
		
	}
	
	
	
	
	
}
