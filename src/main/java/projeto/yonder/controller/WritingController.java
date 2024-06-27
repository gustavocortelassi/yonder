package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.yonder.model.Writing;
import projeto.yonder.model.Usuario;
import projeto.yonder.model.Pergunta;
import projeto.yonder.repository.PerguntaRepository;
import projeto.yonder.service.WritingService;
import projeto.yonder.service.UsuarioService;

@Controller
public class WritingController {

    @Autowired
    private WritingService writingService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PerguntaRepository perguntaRepository;

    @GetMapping("/writing/{id}")
    public String getWriting(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(id);

        Writing writing = new Writing();
        writing.setUsuario(usuario);

        Pergunta pergunta = perguntaRepository.ultimoId();
        String cabecalho = "\"Vamos todos cantar de coração A cruz de malta é o meu pendão Tu tens um nome do heróico Português Vasco da Gama, a tua fama assim se fez Tua imensa torcida é bem feliz Norte-Sul, norte-sul deste Brasil Tua estrela, na Terra a brilhar Ilumina o mar No atletismo és um braço No remo és imortal No futebol és o traço De união Brasil-Portugal No atletismo és um braço No remo és imortal No futebol és o traço De união Brasil-Portugal Vamos todos cantar de coração A cruz de malta é o meu pendão Tu tens um nome do heróico Português Vasco da Gama, a tua fama assim se fez Tua imensa torcida é bem feliz Norte-Sul, norte-sul deste Brasil Tua estrela, na Terra a brilhar Ilumina o mar No atletismo és um braço No remo és imortal No futebol és o traço De união Brasil-Portugal No atletismo és um braço No remo és imortal No futebol és o traço De união Brasil-Portugal\"\n";
        // pergunta != null ? pergunta.getCabecalho() : "Sem pergunta disponível";

        model.addAttribute("writing", writing);
        model.addAttribute("cabecalho", cabecalho);

        return "TelaWriting";
    }

    @PostMapping("/writing/{id}")
    public String postWriting(@PathVariable Long id, @ModelAttribute("writing") Writing writing) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        writing.setUsuario(usuario);
        writing.setCorrigido(false);
        writing.setCorrecao("");
        writingService.save(writing);
        return "redirect:/provaListening/" + id + "/listening/1";
    }

}