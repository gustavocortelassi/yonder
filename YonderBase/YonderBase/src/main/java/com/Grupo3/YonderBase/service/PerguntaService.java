package com.Grupo3.YonderBase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Grupo3.YonderBase.model.Pergunta;
import com.Grupo3.YonderBase.repository.PerguntaRepository;

@Service
public class PerguntaService {
    
    private final PerguntaRepository perguntaRepository;

    public PerguntaService(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    public List<Pergunta> listarPerguntas() {
        return perguntaRepository.findAll();
    }
}
