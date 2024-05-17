package projeto.yonder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CorretorController {
    @GetMapping("/gerenciar-corretores")
    public String gerenciarCorretores() {
        return "gerenciarCorretores"; // falta criar
    }
}
