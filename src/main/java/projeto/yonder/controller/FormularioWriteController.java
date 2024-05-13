package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.yonder.model.FormularioWrite;
import projeto.yonder.service.FormularioWriteService;

@Controller
@RequestMapping("/writing")
public class FormularioWriteController {

    @Autowired
    private FormularioWriteService formularioWriteService;

    @GetMapping("/{id}")
    public String write(@PathVariable Long id, Model model) {
        FormularioWrite formularioWrite = formularioWriteService.findById(id);
        model.addAttribute("formularioWrite", formularioWrite);
        return "TelaWriting";
    }

    @PostMapping("/{id}/writing")
    public String salvar(@PathVariable Long id, @ModelAttribute("formularioWrite") FormularioWrite formularioWrite) {
        formularioWrite.setId(id);
        formularioWriteService.save(formularioWrite);
        return "redirect:/writing/" + id + "/agendamento";
    }

    @GetMapping("/{id}/correcao")
    public String corrigir(@PathVariable Long id, Model model) {
        FormularioWrite formularioWrite = formularioWriteService.findById(id);
        model.addAttribute("formularioWrite", formularioWrite);
        return "TelaCorrecao";
    }

    @PostMapping("/{id}/correcao")
    public String corrigir(@PathVariable Long id, @ModelAttribute("formularioWrite") FormularioWrite formularioWrite) {
        formularioWrite.setId(id);
        formularioWrite.setCorrigido(true);
        formularioWriteService.save(formularioWrite);
        return "redirect:/writing/" + id + "/candidatocorrecao";
    }

    @GetMapping("/{id}/candidatocorrecao")
    public String writeningCorrecao(@PathVariable Long id, Model model) {
        FormularioWrite formularioWrite = formularioWriteService.findById(id);
        model.addAttribute("formularioWrite", formularioWrite);
        return "TelaWritingCorrecao";
    }
}