package com.sistemaescolar.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaescolar.dto.DisciplinaDTO;
import com.sistemaescolar.exceptions.DisciplinaNullException;
import com.sistemaescolar.models.Aluno;
import com.sistemaescolar.models.Boletim;
import com.sistemaescolar.models.Disciplina;
import com.sistemaescolar.repositories.AlunoRepository;

import com.sistemaescolar.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository; 
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    

    public Disciplina AdicionarDisciplina(DisciplinaDTO disciplinaDTO) { 
        if (disciplinaDTO == null || disciplinaDTO.getNome() == null || disciplinaDTO.getNome().isEmpty() 
        		|| disciplinaDTO.getCiclo() == null) {
            throw new DisciplinaNullException();
        }
        
        Disciplina disciplinaModelo = new Disciplina();
        disciplinaModelo.setNome(disciplinaDTO.getNome());
        disciplinaModelo.setNota1(0.0); // Valor inicial
        disciplinaModelo.setNota2(0.0); // Valor inicial
        disciplinaModelo.setCiclo(disciplinaDTO.getCiclo());
        
        
        List<Aluno> alunos = alunoRepository.findByTurmaCiclo(disciplinaDTO.getCiclo());
        List<Disciplina> novasDisciplinas = new ArrayList<>();
        
        for (Aluno aluno : alunos) {
            Boletim boletim = aluno.getBoletim(); // Nunca null para novos alunos
            Disciplina disciplina = new Disciplina();
            disciplina.setNome(disciplinaModelo.getNome());
            disciplina.setNota1(disciplinaModelo.getNota1());
            disciplina.setNota2(disciplinaModelo.getNota2());
            disciplina.setBoletim(boletim); // Associa ao Boletim
            disciplina.setCiclo(disciplinaModelo.getCiclo());
            boletim.getDisciplinas().add(disciplina);
            novasDisciplinas.add(disciplina);
        }
        
        disciplinaRepository.saveAll(novasDisciplinas);
        return disciplinaModelo; // Retorna apenas a Disciplina modelo, sem Boletim
    }


        public Disciplina atualizarNotas(Long id, double nota1, double nota2) {
            Disciplina disciplina = disciplinaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

            disciplina.setNota1(nota1);
            disciplina.setNota2(nota2);

            return disciplinaRepository.save(disciplina);
        
    }







}
