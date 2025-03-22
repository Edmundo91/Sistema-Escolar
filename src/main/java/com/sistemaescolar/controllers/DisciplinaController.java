package com.sistemaescolar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaescolar.dto.DisciplinaDTO;
import com.sistemaescolar.models.Disciplina;
import com.sistemaescolar.services.DisciplinaService;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaService service;
	
	
	@PostMapping("/save")
	public Disciplina RegistrarDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) { 
		
		return service.AdicionarDisciplina(disciplinaDTO);
		
	}
	
	
	
}
