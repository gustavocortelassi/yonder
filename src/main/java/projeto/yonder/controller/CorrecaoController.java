package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.yonder.model.FormularioWrite;
import projeto.yonder.service.FormularioWriteService;

@Controller
public class CorrecaoController {

    @Autowired
    private FormularioWriteService formularioWriteService;

    @GetMapping("/correcao/{id}")
    public String getCorrecao(@PathVariable Long id, Model model) {
        FormularioWrite formularioWrite = formularioWriteService.findById(id);
        model.addAttribute("formularioWrite", formularioWrite);
        return "TelaCorrecaoProva";
    }

    @GetMapping("/correcaowriting/{id}")
    public String getCorrecaoWriting(@PathVariable Long id, Model model) {
        FormularioWrite formularioWrite = formularioWriteService.findById(id);
        model.addAttribute("formularioWrite", formularioWrite);
        return "TelaCorrecaoWriting";
    }

    @PostMapping("/correcaowriting/{id}")
    public String postCorrecao(@PathVariable Long id, @ModelAttribute("formularioWrite") FormularioWrite formularioWrite) {
        FormularioWrite existingFormularioWrite = formularioWriteService.findById(id);
        existingFormularioWrite.setCorrecao(formularioWrite.getCorrecao());
        existingFormularioWrite.setCorrigido(true);
        formularioWriteService.save(existingFormularioWrite);
        return "redirect:/";
    }

    @GetMapping("/aprovar-correcoes")
    public String aprovarCorrecoes() {
        return "aprovarCorrecoes"; // falta criar
    }

}