package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projeto.yonder.model.Pergunta;
import projeto.yonder.repository.PerguntaRepository;
import projeto.yonder.repository.RespostasRepository;

@Controller
@RequestMapping("/MultiplaEscolha/{userId}")
public class FormularioReadMEscolhaController {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private RespostasRepository respostasRepository;

    // definir um limite momentaneo no formulario
    private static final int TOTAL_PERGUNTAS = 10;

    @GetMapping("/multEscolha/{perguntaId}")
    public String exibirFormulario(@PathVariable("userId") Long userId, @PathVariable("perguntaId") Long perguntaId, @RequestParam(value = "contador", defaultValue = "0") int contador, Model model) {
        Pergunta pergunta = perguntaRepository.findById(perguntaId).orElse(null);

        if (pergunta != null) {
            model.addAttribute("pergunta", pergunta);
            model.addAttribute("respostas", pergunta.getResposta());
            model.addAttribute("userId", userId);
            model.addAttribute("proximaPerguntaId", perguntaId);
            model.addAttribute("contador", contador);
        } else {
            model.addAttribute("mensagem", "Não há mais perguntas disponíveis.");
            return "TelaResultado";
        }

        return "TelaProvaReadingMescolha";
    }

    @PostMapping("/multEscolha/{perguntaId}")
    public String processarFormulario(@PathVariable("userId") Long userId, @PathVariable("perguntaId") Long perguntaId, @RequestParam("resposta") Long respostaId, @RequestParam("contador") int contador) {
        contador++;
        if (contador >= TOTAL_PERGUNTAS) {
            return "redirect:/MultiplaEscolha/" + userId + "/resultado";
        }
        // puxar o user id + pergunta e contador
        return "redirect:/MultiplaEscolha/" + userId + "/multEscolha/" + (perguntaId + 1) + "?contador=" + contador;
    }
}
