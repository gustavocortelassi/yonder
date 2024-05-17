package com.Grupo3.YonderBase.service;

import com.Grupo3.YonderBase.model.Pergunta;
import com.Grupo3.YonderBase.repository.PerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PerguntaService {

    private final PerguntaRepository perguntaRepository;

    public PerguntaService(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }
    public void excluirPergunta(Long id){
    perguntaRepository.deleteById(id);
    }

    public void editarPergunta(Long perguntaId, Pergunta pergunta) {
        // Verifica se a pergunta com o ID especificado existe no banco de dados
        Pergunta perguntaExistente = perguntaRepository.findById(perguntaId)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada com o ID: " + perguntaId));

        perguntaExistente.setCabecalho(pergunta.getCabecalho());
        perguntaExistente.setDificuldade(pergunta.getDificuldade());
        perguntaExistente.setTipoProvaId(pergunta.getTipoProvaId());
        perguntaExistente.setNiveisId(pergunta.getNiveisId());
        perguntaExistente.setAudio(pergunta.getAudio());
        perguntaRepository.save(perguntaExistente);
    }
}
