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

import com.sistemaescolar.dto.AlunoDTO;
import com.sistemaescolar.models.Aluno;
import com.sistemaescolar.services.AlunoService;


@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
    
	@Autowired 
	private AlunoService service;
	
	//Endpoint para registrar aluno
    @PostMapping("/save")
	public Aluno registrarAluno(@RequestBody AlunoDTO alunoDTO){ 
	
	 return service.salvarAluno(alunoDTO); 
    	
    }

    
    //Endpoint para buscar aluno por nome
    @GetMapping("/busca")
    public List<Aluno> buscarAlunoPorNome(@RequestParam String nome) { 
    	
    	return service.buscarPorNome(nome);
    	
    }
        
    //Endpoint para buscar aluno por id
   @GetMapping("/{id}") 
   public Aluno buscarAlunoPorId(@PathVariable Long id){ 
	   
	   return service.buscarAlunoPorId(id); 
	   
   }
    
   
   
   //Endpoint para deletar aluno
   @DeleteMapping("/{id}") 
   public String deletarAluno(@PathVariable Long id) { 
	   
	 return service.deletarAluno(id); 
	     
   } 
   
   
   
    
}
