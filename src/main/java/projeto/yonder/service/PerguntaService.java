package projeto.yonder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.yonder.model.Pergunta;
import projeto.yonder.repository.PerguntaRepository;

import java.util.Optional;

@Service
public class PerguntaService {

    private final PerguntaRepository perguntaRepository;

    public PerguntaService(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }
    public void excluirPergunta(Long id){
        perguntaRepository.deleteById(id);
    }

    public Pergunta findById(Long id) {
        Optional<Pergunta> pergunta = perguntaRepository.findById(id);
        return pergunta.orElse(null);
    }



    public void editarPergunta(Long perguntaId, Pergunta pergunta) {

        Pergunta perguntaExistente = perguntaRepository.findById(perguntaId)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada com o ID: " + perguntaId));

        perguntaExistente.setCabecalho(pergunta.getCabecalho());
        perguntaExistente.setTipoProvaId(pergunta.getTipoProvaId());
        perguntaExistente.setAudio(pergunta.getAudio());
        perguntaRepository.save(perguntaExistente);
    }
}