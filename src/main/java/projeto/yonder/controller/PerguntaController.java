package projeto.yonder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import projeto.yonder.model.Pergunta;
import projeto.yonder.service.PerguntaService;

@Controller
public class PerguntaController {
    
    @Autowired
    private PerguntaService perguntaService;

    @GetMapping("/perguntas")
    public String getAllPerguntas(Model model) {
        List<Pergunta> perguntas = perguntaService.listarPerguntas();
        model.addAttribute("perguntas", perguntas);
        return "/lista-perguntas";
    }

    @GetMapping("/gerenciar-perguntas")
    public String gerenciarQuestoes() {
        return "gerenciarPerguntas"; //falta criar
    }
}
