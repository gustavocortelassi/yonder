package projeto.yonder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import projeto.yonder.repository.PerguntaRepository;

@Service
public class PerguntaService {
    
    private final PerguntaRepository perguntaRepository;

    public PerguntaService(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    public List<projeto.yonder.model.Pergunta> listarPerguntas() {
        return perguntaRepository.findAll();
    }
}
