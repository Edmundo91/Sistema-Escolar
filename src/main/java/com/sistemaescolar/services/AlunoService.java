package com.sistemaescolar.services;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaescolar.dto.AlunoDTO;
import com.sistemaescolar.exceptions.AlunoNotFoundException;
import com.sistemaescolar.exceptions.AlunoNullException;
import com.sistemaescolar.exceptions.TurmaNullException;
import com.sistemaescolar.models.Aluno;
import com.sistemaescolar.models.Boletim;

import com.sistemaescolar.models.Turma;
import com.sistemaescolar.repositories.AlunoRepository;


import com.sistemaescolar.repositories.TurmaRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
    private TurmaRepository turmaRepository;
	
	
	// Criar um Aluno
	public Aluno salvarAluno(AlunoDTO alunoDTO) { 
	
	if(alunoDTO.getNome() == null || alunoDTO.getTurmaNome() == null) { 
			throw new AlunoNullException();	
	}
		
	
	Turma turma = turmaRepository.findByNome(alunoDTO.getTurmaNome());
	
	if(turma == null) { 
		  
		  throw new TurmaNullException();   
	  }
	 
	  Aluno aluno = new Aluno();
	        aluno.setNome(alunoDTO.getNome()); 
	        aluno.setDataNascimento(LocalDate.parse(alunoDTO.getDataNascimento())); 
	        aluno.setCpfFormat(alunoDTO.getCpf()); 
	        aluno.setEndereco(alunoDTO.getEndereco());
	        aluno.setTurma(turma);
			
	        Boletim boletim = new Boletim();
	     
	        aluno.setBoletim(boletim);
	        
	      
	    	    return alunoRepository.save(aluno);
	       
   
		}	
		
	
	

    // Buscar aluno por ID
    public Aluno buscarAlunoPorId(Long id) {
    	 return alunoRepository.findById(id)
    			.orElseThrow(() -> new AlunoNotFoundException());
    }

    // Buscar alunos pelo nome
    public List<Aluno> buscarPorNome(String nome) {
        
    	List<Aluno> alunos = alunoRepository.findByNomeContainingIgnoreCase(nome);
       
    	if(alunos.isEmpty()) { 
    		throw new AlunoNotFoundException(); 
    		
    	}
    	
    	return alunos;
    
    }

    
    
    // Deletar aluno
    public String deletarAluno(Long id) {
 
    	if (!alunoRepository.existsById(id)) {
            throw new AlunoNotFoundException();
        }
       alunoRepository.deleteById(id); 
    
       return "aluno deletado";
    }
	
	
	
}
