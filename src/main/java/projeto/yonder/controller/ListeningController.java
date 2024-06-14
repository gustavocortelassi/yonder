package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.yonder.model.Pergunta;
import projeto.yonder.model.Respostas;
import projeto.yonder.model.Usuario;
import projeto.yonder.repository.PerguntaRepository;
import projeto.yonder.repository.RespostasRepository;
import projeto.yonder.repository.UsuarioRepository;
import projeto.yonder.service.UsuarioService;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/listening/{userId}")
public class ListeningController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private RespostasRepository respostasRepository;

    @GetMapping("/question/{id}")
    public String ExibirFormulario(Model model, @PathVariable Long userId, @PathVariable Long perguntaId) {
        Usuario usuario = usuarioService.getUsuarioById(userId);
        Pergunta pergunta = perguntaRepository.findById(perguntaId).orElse(null);

        if (pergunta != null) {
            model.addAttribute("pergunta", pergunta);
            model.addAttribute("respostas", pergunta.getRespostas());
            model.addAttribute("userId", userId);
            model.addAttribute("proximaPerguntaId", perguntaId);
        } else {
            model.addAttribute("mensagem", "Não há mais perguntas disponíveis.");
            return "TelaResultado";
        }
        return "TelaProvaListening";
    }

    @PostMapping("/question/{id}")
    public String processarFormulario(@PathVariable Long userId, @PathVariable Long perguntaId, @RequestParam("resposta") Long respostaId) {
        Usuario usuario = usuarioService.getUsuarioById(userId);
        Pergunta pergunta = perguntaRepository.findById(perguntaId).orElse(null);
        Respostas resposta = respostasRepository.findById(respostaId).orElse(null);
        return "redirect:/listening/" + userId + "/question/" + (perguntaId + 1);
    }

}
