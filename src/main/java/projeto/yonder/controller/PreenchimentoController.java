package projeto.yonder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PreenchimentoController {

    @GetMapping("/preencher")
    public String prencher() {

        return "TelaReadingPreenchimento";
    }
}