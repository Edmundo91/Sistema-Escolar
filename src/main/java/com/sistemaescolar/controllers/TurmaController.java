package com.sistemaescolar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaescolar.models.Turma;
import com.sistemaescolar.services.TurmaService;

@Controller

@RestController
@RequestMapping(value = "/turma")
public class TurmaController {

	@Autowired 
	private TurmaService service;
	
	
	
	//Endpoint para criar uma turma
    @PostMapping("/save")
	public Turma registrarTurma(@RequestBody Turma turma){ 
	
	 return service.criarTurma(turma);
    	
    }

    
    //Endpoint para buscar todas as turmas
    @GetMapping("/listar")
    public List<Turma> listarTurmas() { 
    	
    	return service.listarTurmas(); 
    	
    }
        
    
   //Endpoint para deletar turma
  @DeleteMapping("{id}")
   public String deletarTurma(@PathVariable  Long id) { 
	   
	return service.deletarTurma(id); 
	 
	
   }
	
	
	
		
}
