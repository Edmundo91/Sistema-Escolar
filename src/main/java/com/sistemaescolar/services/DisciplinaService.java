package com.sistemaescolar.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaescolar.dto.DisciplinaDTO;
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
        if (disciplinaDTO == null || disciplinaDTO.getNome() == null || disciplinaDTO.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da disciplina é obrigatório");
        }
        
        Disciplina disciplinaModelo = new Disciplina();
        disciplinaModelo.setNome(disciplinaDTO.getNome());
        disciplinaModelo.setNota1(0.0); // Valor inicial
        disciplinaModelo.setNota2(0.0); // Valor inicial
        
        List<Aluno> alunos = alunoRepository.findAll();
        List<Disciplina> novasDisciplinas = new ArrayList<>();
        
        for (Aluno aluno : alunos) {
            Boletim boletim = aluno.getBoletim(); // Nunca null para novos alunos
            Disciplina disciplina = new Disciplina();
            disciplina.setNome(disciplinaModelo.getNome());
            disciplina.setNota1(disciplinaModelo.getNota1());
            disciplina.setNota2(disciplinaModelo.getNota2());
            disciplina.setBoletim(boletim); // Associa ao Boletim
            boletim.getDisciplinas().add(disciplina);
            novasDisciplinas.add(disciplina);
        }
        
        disciplinaRepository.saveAll(novasDisciplinas);
        return disciplinaModelo; // Retorna apenas a Disciplina modelo, sem Boletim
    }
}
