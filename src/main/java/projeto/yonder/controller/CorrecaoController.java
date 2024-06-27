package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.yonder.model.Writing;
import projeto.yonder.service.WritingService;

@Controller
public class CorrecaoController {

    @Autowired
    private WritingService writingService;

    @GetMapping("/correcao/{id}")
    public String getCorrecao(@PathVariable Long id, Model model) {
        Writing writing = writingService.findById(id);
        String nome = writing.getUsuario().getNome();
        String notaWriting = writing.getUsuario().getNotaWriting();
        String notaReading = writing.getUsuario().getNotaReading();

        model.addAttribute("writing", writing);
        model.addAttribute("id", id);
        model.addAttribute("nome", nome);
        model.addAttribute("notaWriting", notaWriting);
        model.addAttribute("notaReading", notaReading);
        return "TelaCorrecaoProva";
    }

    @GetMapping("/correcaowriting/{id}")
    public String getCorrecaoWriting(@PathVariable Long id, Model model) {
        Writing writing = writingService.findById(id);
        String notaWriting = writing.getUsuario().getNotaWriting();
        model.addAttribute("writing", writing);
        model.addAttribute("id", id);
        model.addAttribute("notaWriting", notaWriting);
        return "TelaCorrecaoWriting";

    }

    @PostMapping("/correcaowriting/{id}")
    public String postCorrecaoWriting(@PathVariable Long id, @ModelAttribute("writing") Writing writing, @RequestParam("notaSelecionada") String notaSelecionada) {
        Writing existingWriting = writingService.findById(id);
        if (existingWriting != null) {
            existingWriting.setCorrecao(writing.getCorrecao());
            existingWriting.setCorrigido(true);
            existingWriting.getUsuario().setNotaWriting(notaSelecionada);
            writingService.save(existingWriting);
        }
        return "redirect:/correcao/" + id;
    }

    @PostMapping("/salvarFeedback/{id}")
    public String salvarFeedback(@PathVariable Long id, @ModelAttribute("writing") Writing writing) {
        Writing existingWriting = writingService.findById(id);
        existingWriting.getUsuario().setFeedback(writing.getUsuario().getFeedback());
        writingService.save(existingWriting);
        return "redirect:/correcao/" + id;
    }
}