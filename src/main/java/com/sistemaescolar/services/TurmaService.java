package com.sistemaescolar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaescolar.models.Aluno;
import com.sistemaescolar.models.Turma;
import com.sistemaescolar.repositories.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
	private TurmaRepository turmaRepository;
	
    
    public Turma criarTurma (Turma turma) { 
    	
    return turmaRepository.save(turma);	
    }
    
    
    
    public List<Turma> listarTurmas(){ 
    	return turmaRepository.findAll();
    }
    
    
    public List<Aluno> listarAlunos(String nome){ 
    	
    	return turmaRepository.findByNomeContainingIgnoreCase(nome);
    	
    }
    
    
    
    
    
    public void deletarTurma(Long id) {
        if (!turmaRepository.existsById(id)) {
            throw new IllegalArgumentException("Turma com ID " + id + " não encontrada.");
        }
        turmaRepository.deleteById(id);
    }
	
    
	
}
