package com.sistemaescolar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaescolar.exceptions.AlunoNotFoundException;
import com.sistemaescolar.exceptions.TurmaNotFoundException;
import com.sistemaescolar.exceptions.TurmaNullException;
import com.sistemaescolar.models.Aluno;
import com.sistemaescolar.models.Turma;
import com.sistemaescolar.repositories.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
	private TurmaRepository turmaRepository;
	
    
    public Turma criarTurma (Turma turma) { 
    	if(turma.getNome() == null || turma.getAno() == null) { 
    		
    		throw new TurmaNullException(); 		
    	}
    
    	return turmaRepository.save(turma);	
    
    }
    
    
    
    public List<Turma> listarTurmas(){ 
    	
    	List<Turma> turmas = turmaRepository.findAll(); 
    	
    	if(turmas.isEmpty()) { 
    	
    		throw new TurmaNotFoundException();
   
    	}
   
    	return turmas;
    }
    
    
    public List<Aluno> listarAlunos(String nome){ 
    	
    	List<Aluno> alunos = turmaRepository.findByNomeContainingIgnoreCase(nome);
    	
    	if(alunos.isEmpty()) { 
    		
    		throw new AlunoNotFoundException();
    		
    	}
    	
    	return alunos;
    	
    }
    
    
    
    
    
    public void deletarTurma(Long id) {
        if (!turmaRepository.existsById(id)) {
            throw new TurmaNotFoundException();
        }
        turmaRepository.deleteById(id);
    }
	
    
	
}
