package com.sistemaescolar.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaescolar.exceptions.AlunoNotFoundException;
import com.sistemaescolar.exceptions.AlunoNullException;
import com.sistemaescolar.models.Aluno;
import com.sistemaescolar.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	
	// Criar um Aluno
	public Aluno salvarAluno(Aluno aluno) { 
	
		if(aluno.getNome() == null || aluno.getTurma() == null) { 
			throw new AlunoNullException();	
		}
		
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
    public void deletarAluno(Long id) {
 
    	if (!alunoRepository.existsById(id)) {
            throw new AlunoNotFoundException();
        }
       alunoRepository.deleteById(id); 
    }
	
	
	
}
