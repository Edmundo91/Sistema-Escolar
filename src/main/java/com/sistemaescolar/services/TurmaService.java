package com.sistemaescolar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaescolar.dto.TurmaDTO;
import com.sistemaescolar.exceptions.AlunoNotFoundException;
import com.sistemaescolar.exceptions.TurmaNotFoundException;
import com.sistemaescolar.exceptions.TurmaNullException;
import com.sistemaescolar.models.Aluno;
import com.sistemaescolar.models.Ano;
import com.sistemaescolar.models.Periodo;
import com.sistemaescolar.models.Turma;
import com.sistemaescolar.repositories.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
	private TurmaRepository turmaRepository;
	
    
    
    public Turma criarTurma (TurmaDTO turmaDTO) { 
    	
    	
    	System.out.println("turma");
    	
    	if(turmaDTO.getNome() == null || turmaDTO.getAnoLetivo() == null 
    		|| turmaDTO.getTurno() == null || turmaDTO.getCiclo() == null) { 
    		
    		throw new TurmaNullException(); 		
    	}
    
    	Turma turma = new Turma(); 
    	
    	turma.setNome(turmaDTO.getNome());
    	
    	
    	// instancia o ano para settar na turma
    	Ano ano = new Ano();
        
    	ano.setAno(turmaDTO.getAnoLetivo()); 

        turma.setAno(ano); 
        
        //instancia o periodo para settar na turma 
        Periodo periodo = new Periodo();
        
        periodo.setPeriodo(turmaDTO.getTurno());
        
        turma.setPeriodo(periodo);
        
        turma.setCiclo(turmaDTO.getCiclo());
    	
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
    
    
    
    
    
    public String deletarTurma(Long id) {
        if (!turmaRepository.existsById(id)) {
            throw new TurmaNotFoundException();
        }
        turmaRepository.deleteById(id);
    
        return "Turma deletada";
    }
	
    
	
}
