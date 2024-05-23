package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.yonder.model.FormularioWrite;
import projeto.yonder.service.FormularioWriteService;

@Controller
public class FormularioWriteController {

    @Autowired
    private FormularioWriteService formularioWriteService;

    @GetMapping("/prova")
    public String formularioWrite(Model model) {
        model.addAttribute("formularioWrite", new FormularioWrite());
        return "TelaWriting";
    }

    @PostMapping("/prova")
    public String salvar(@ModelAttribute("formularioWrite") FormularioWrite formularioWrite) {
        formularioWrite.setId(null);
        formularioWrite.setCorrigido(false);
        formularioWriteService.save(formularioWrite);
        return "redirect:/prova";
    }

    @GetMapping("/respostas")
    public String writeningCorrecao(@RequestParam("id") Long id, Model model) {
        FormularioWrite formularioWrite = formularioWriteService.findById(id);
        model.addAttribute("formularioWrite", formularioWrite);
        return "TelaCandidatoRespostas";
    }

    @GetMapping("/correcaowriting")
    public String corrigir(@RequestParam("id") Long id, Model model) {
        FormularioWrite formularioWrite = formularioWriteService.findById(id);
        model.addAttribute("formularioWrite", formularioWrite);
        return "TelaCorrecaoWriting";
    }

    @PostMapping("/correcaowriting")
    public String corrigir(@ModelAttribute("formularioWrite") FormularioWrite formularioWrite) {
        formularioWrite.setCorrigido(true);
        formularioWriteService.save(formularioWrite);
        return "redirect:/respostas/writing";
    }
}