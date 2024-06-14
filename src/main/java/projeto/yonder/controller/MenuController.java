package projeto.yonder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    
    @GetMapping("/")
    public String home(Model model){
        return "TelaMenu";
    }

    
}

