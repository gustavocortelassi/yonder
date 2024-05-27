package projeto.yonder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
<<<<<<<< HEAD:src/main/java/projeto/yonder/controller/PreenchimentoController.java
public class PreenchimentoController {
========
public class MenuController {
    
    @GetMapping("/")
    public String home(Model model){
        return "TelaMenu";
    }
}
>>>>>>>> main:src/main/java/projeto/yonder/controller/MenuController.java

    @GetMapping("/preencher")
    public String prencher() {
        
        return "TelaReadingPreenchimento";
    }
    
}
