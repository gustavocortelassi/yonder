package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import projeto.yonder.model.Pergunta;
import projeto.yonder.model.Usuario;
import projeto.yonder.repository.PerguntaRepository;
import projeto.yonder.repository.RespostasRepository;
import projeto.yonder.repository.UsuarioRepository;
import projeto.yonder.service.UsuarioService;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class ListeningController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private RespostasRepository respostasRepository;

    @GetMapping("/listening/{id}")
    public String ExibirFormulario(Model model, @PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        Pergunta pergunta = perguntaRepository.findById(id).orElse(null);

        if (pergunta != null) {
            model.addAttribute("pergunta", pergunta);
            model.addAttribute("respostas", pergunta.getRespostas());
        }

        return "TelaProvaListening";

    }

}
