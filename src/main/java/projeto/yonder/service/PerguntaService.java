package projeto.yonder.service;

import org.springframework.stereotype.Service;

import projeto.yonder.model.Pergunta;
import projeto.yonder.repository.PerguntaRepository;

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
