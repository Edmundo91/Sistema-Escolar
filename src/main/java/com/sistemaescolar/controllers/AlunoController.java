package com.sistemaescolar.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaescolar.models.Aluno;
import com.sistemaescolar.services.AlunoService;


@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
    
	@Autowired 
	private AlunoService service;
	
	//Endpoint para registrar aluno
    @PostMapping("/save")
	public Aluno registrarAluno(Aluno aluno){ 
	
	 return service.salvarAluno(aluno); 
    	
    }

    
    //Endpoint para buscar aluno por nome
    @GetMapping("/busca")
    public List<Aluno> buscarAlunoPorNome(String name) { 
    	
    	return service.buscarPorNome(name);
    	
    }
        
    //Endpoint para buscar aluno por id
   @GetMapping("/{id}") 
   public Aluno buscarAlunoPorId(Long id){ 
	   
	   return service.buscarAlunoPorId(id); 
	   
   }
    
   
   
   //Endpoint para deletar aluno
   @DeleteMapping("/{id}") 
   public void deletarAluno(Long id) { 
	   
	 service.deletarAluno(id); 
	     
   } 
   
   
   
    
}
