package com.sistemaescolar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaescolar.dto.DisciplinaDTO;
import com.sistemaescolar.dto.NotaRequestDTO;
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
	
	
	
	 @PutMapping("/{id}/notas")
	    public ResponseEntity<Disciplina> atualizarNotas(
	            @PathVariable Long id,
	            @RequestBody NotaRequestDTO notas) {

	        Disciplina disciplinaAtualizada = service.atualizarNotas(id, notas.nota1, notas.nota2);
	        return ResponseEntity.ok(disciplinaAtualizada);
	    }
	
}
	
	
	

