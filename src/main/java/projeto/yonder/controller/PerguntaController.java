package projeto.yonder.controller;

import projeto.yonder.model.Pergunta;
import projeto.yonder.model.Resposta;
import projeto.yonder.repository.PerguntaRepository;
import projeto.yonder.repository.RespostasRepository;
import projeto.yonder.service.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PerguntaController {

    @Autowired
    PerguntaRepository perguntaRepository;
    @Autowired
    PerguntaService perguntaService;
    @Autowired
    private RespostasRepository respostasRepository;

    @GetMapping("/pergunta")
    public String showList(Model model, @RequestParam (defaultValue="0") int page) {
        model.addAttribute("data", perguntaRepository.findAll( PageRequest.of(page, 20, Sort.by(
                Sort.Order.asc("id")))));
        model.addAttribute("currentPage", page);
        return "TelaVisualizarPerguntas";
    }

    @GetMapping("/pergunta/{id}")
    public ResponseEntity<Map<String, Object>> showPergunta(@PathVariable Long id) {
        Pergunta pergunta = perguntaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pergunta inválida"));

        Map<String, Object> response = new HashMap<>();
        response.put("pergunta", pergunta);
        response.put("respostas", pergunta.getResposta());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/savePergunta")
    public ResponseEntity<String> saveAddPergunta(@RequestBody Pergunta pergunta) {
        try {
            // Associa cada resposta à pergunta
            for (Resposta resposta : pergunta.getResposta()) {
                resposta.setPergunta(pergunta);
            }

            // Salva a pergunta (e as respostas em cascata)
            perguntaRepository.save(pergunta);

            return ResponseEntity.ok().body("{\"message\": \"Pergunta salva com sucesso!\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Erro ao salvar pergunta: " + e.getMessage() + "\"}");
        }
    }


    @DeleteMapping("pergunta/delete/{id}")
    public ResponseEntity<?> excluirPergunta(@PathVariable Long id) {
        try {
            perguntaService.excluirPergunta(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir a pergunta");
        }
    }

    @PostMapping("/pergunta/editar/{id}")
    public ResponseEntity<?> updatePergunta(@PathVariable Long id, @RequestBody Pergunta perguntaDetails) {
        try {
            Pergunta pergunta = perguntaRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Pergunta inválida"));

            pergunta.setTipoProvaId(perguntaDetails.getTipoProvaId());
            pergunta.setCabecalho(perguntaDetails.getCabecalho());
            pergunta.setDificuldade(perguntaDetails.getDificuldade());
            pergunta.setNiveisId(perguntaDetails.getNiveisId());
            pergunta.setAudio(perguntaDetails.getAudio());

            // Limpar as respostas antigas e adicionar as novas
            pergunta.getResposta().clear();
            for (Resposta resposta : pergunta.getResposta()) {
                resposta = new Resposta();
                resposta.setTitulo(resposta.getTitulo());
                resposta.setCorreto(resposta.isCorreto());
                resposta.setPergunta(pergunta);
                pergunta.getResposta().add(resposta);
            }

            Pergunta updatedPergunta = perguntaRepository.save(pergunta);
            return ResponseEntity.ok(updatedPergunta);
        } catch (Exception e) {
            e.printStackTrace(); // Adicionar log do erro no console do servidor
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar a pergunta: " + e.getMessage());
        }
    }


}