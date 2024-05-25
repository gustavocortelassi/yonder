package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projeto.yonder.model.Pergunta;
import projeto.yonder.model.Respostas;
import projeto.yonder.repository.PerguntaRepository;
import projeto.yonder.repository.RespostasRepository;

@Controller
public class FormularioReadMEscolhaController {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private RespostasRepository respostasRepository;

    @GetMapping("/formulario")
    public String exibirFormulario(Model model) {
        Pergunta pergunta = perguntaRepository.findById(10L).orElse(null);

        if (pergunta != null) {
            model.addAttribute("pergunta", pergunta);
            model.addAttribute("respostas", pergunta.getRespostas());
        }

        return "formulario";
    }

    @PostMapping("/formulario")
    public String processarFormulario(@RequestParam("resposta") Long respostaId, Model model) {
        Respostas resposta = respostasRepository.findById(respostaId).orElse(null);

        if (resposta != null && resposta.isCorreto()) {
            model.addAttribute("mensagem", "Parabéns! Você acertou.");
        } else {
            model.addAttribute("mensagem", "Que pena! Você errou.");
        }

        return "resultado";
    }

    @GetMapping("/nova-pergunta")
    public String exibirNovaPergunta(Model model) {
        Pergunta novaPergunta = perguntaRepository.findById(3L).orElse(null);

        if (novaPergunta != null) {
            model.addAttribute("pergunta", novaPergunta);
            model.addAttribute("respostas", novaPergunta.getRespostas());
        }

        return "formulario";
    }
}
