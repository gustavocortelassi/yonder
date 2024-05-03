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
    public void editarPergunta(Long perguntaId, String cabecalho, Long dificuldade, String tipoProvaId, Long niveisId, String audio) {
        Pergunta pergunta = perguntaRepository.findById(perguntaId).get();
        pergunta.setId(perguntaId);
        pergunta.setCabecalho(cabecalho);
        pergunta.setDificuldade(dificuldade);
        pergunta.setTipoProvaId(tipoProvaId);
        pergunta.setNiveisId(niveisId);
        pergunta.setAudio(audio);
        perguntaRepository.save(pergunta);
    }

}
