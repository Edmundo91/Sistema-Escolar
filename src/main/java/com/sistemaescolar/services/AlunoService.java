package com.sistemaescolar.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaescolar.dto.AlunoDTO;
import com.sistemaescolar.enums.CicloEnum;
import com.sistemaescolar.exceptions.AlunoNotFoundException;
import com.sistemaescolar.exceptions.AlunoNullException;
import com.sistemaescolar.exceptions.TurmaNullException;
import com.sistemaescolar.models.Aluno;
import com.sistemaescolar.models.Boletim;
import com.sistemaescolar.models.Disciplina;
import com.sistemaescolar.models.Turma;
import com.sistemaescolar.repositories.AlunoRepository;
import com.sistemaescolar.repositories.DisciplinaRepository;
import com.sistemaescolar.repositories.TurmaRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
    private TurmaRepository turmaRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	// Criar um Aluno
	public Aluno salvarAluno(AlunoDTO alunoDTO) { 
	
	if(alunoDTO.getNome() == null || alunoDTO.getTurmaNome() == null) { 
			throw new AlunoNullException();	
	}
		
	
	Turma turma = turmaRepository.findByNome(alunoDTO.getTurmaNome());
	
	
	if(turma == null) { 
		  
		  throw new TurmaNullException();   
	  }
	 
	CicloEnum ciclo = turma.getCiclo();
	
	List<Disciplina> disciplinasBase = disciplinaRepository.findByCiclo(ciclo);
	
	List<Disciplina> disciplinasUnicas = disciplinasBase.stream()
		    .collect(Collectors.collectingAndThen(
		        Collectors.toMap(
		            Disciplina::getNome,   
		            d -> d,                
		            (d1, d2) -> d1        
		        ),
		        map -> new ArrayList<>(map.values())
		    ));
	
	
	System.out.println("Disciplinas base encontradas: " + disciplinasBase.size());
	
	Aluno aluno = new Aluno();
	        aluno.setNome(alunoDTO.getNome()); 
	        aluno.setDataNascimento(LocalDate.parse(alunoDTO.getDataNascimento())); 
	        aluno.setCpfFormat(alunoDTO.getCpf()); 
	        aluno.setEndereco(alunoDTO.getEndereco());
	        aluno.setTurma(turma);
			
	        Boletim boletim = new Boletim();
	        boletim.setAluno(aluno);
	        
	      
	        	List<Disciplina> disciplinas = disciplinasUnicas.stream().map(base -> {
	        	    Disciplina d = new Disciplina();
	        	    d.setNome(base.getNome());
	        	    d.setBoletim(boletim);
	        	    return d;
	        	}).collect(Collectors.toList());
	        	
	        	boletim.setDisciplinas(disciplinas);
	      
	        
	        
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
