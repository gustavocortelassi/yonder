package projeto.yonder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CorrecaoController {
    
    @GetMapping("/aprovar-correcoes")
    public String aprovarCorrecoes() {
        return "aprovarCorrecoes"; // falta criar
    }
}
