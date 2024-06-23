package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.yonder.model.FormularioWrite;
import projeto.yonder.service.FormularioWriteService;
import projeto.yonder.service.UsuarioService;

@Controller
public class CorrecaoController {

    @Autowired
    private FormularioWriteService formularioWriteService;

    @GetMapping("/correcao/{id}")
    public String getCorrecao(@PathVariable Long id, Model model) {
        FormularioWrite formularioWrite = formularioWriteService.findById(id);
        String nome = formularioWrite.getUsuario().getNome();
        String notaWriting = formularioWrite.getNotaWriting();

        model.addAttribute("formularioWrite", formularioWrite);
        model.addAttribute("id", id);
        model.addAttribute("nome", nome);
        model.addAttribute("notaWriting", notaWriting);
        return "TelaCorrecaoProva";
    }


    @GetMapping("/correcaowriting/{id}")
    public String getCorrecaoWriting(@PathVariable Long id, Model model) {
        FormularioWrite formularioWrite = formularioWriteService.findById(id);
        model.addAttribute("formularioWrite", formularioWrite);
        model.addAttribute("id", id);
        return "TelaCorrecaoWriting";
    }

    @PostMapping("/correcaowriting/{id}")
    public String postCorrecaoWriting(
            @PathVariable Long id,
            @ModelAttribute("formularioWrite") FormularioWrite formularioWrite,
            @RequestParam("notaSelecionada") String notaSelecionada
    ) {
        FormularioWrite existingFormularioWrite = formularioWriteService.findById(id);
        if (existingFormularioWrite != null) {
            existingFormularioWrite.setCorrecao(formularioWrite.getCorrecao());
            existingFormularioWrite.setNotaWriting(notaSelecionada);
            existingFormularioWrite.setCorrigido(true);
            formularioWriteService.save(existingFormularioWrite);
        }
        return "redirect:/correcao/" + id;
    }

    @PostMapping("/salvarFeedback/{id}")
    public String salvarFeedback(@PathVariable Long id, @ModelAttribute("formularioWrite") FormularioWrite formularioWrite) {
        FormularioWrite existingFormularioWrite = formularioWriteService.findById(id);
        existingFormularioWrite.getUsuario().setFeedback(formularioWrite.getUsuario().getFeedback());
        formularioWriteService.save(existingFormularioWrite);
        return "redirect:/correcao/" + id;
    }
}