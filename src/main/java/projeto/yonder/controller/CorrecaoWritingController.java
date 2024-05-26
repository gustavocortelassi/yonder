package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.yonder.model.FormularioWrite;
import projeto.yonder.service.FormularioWriteService;

@Controller
public class CorrecaoWritingController {

    @Autowired
    private FormularioWriteService formularioWriteService;

    @GetMapping("/correcaotexto/{id}")
    public String getCorrecao(@PathVariable Long id, Model model) {
        FormularioWrite formularioWrite = formularioWriteService.findById(id);
        model.addAttribute("formularioWrite", formularioWrite);
        return "TelaCorrecaoWriting";
    }

    @PostMapping("/correcaotexto/{id}")
    public String salvarCorrecao(@PathVariable Long id, @ModelAttribute("formularioWrite") FormularioWrite formularioWrite) {
        FormularioWrite existingFormularioWrite = formularioWriteService.findById(id);
        existingFormularioWrite.setCorrecao(formularioWrite.getCorrecao());
        existingFormularioWrite.setCorrigido(true);
        formularioWriteService.save(existingFormularioWrite);
        return "redirect:/respostas";
    }
}

