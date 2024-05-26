package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.yonder.model.FormularioWrite;
import projeto.yonder.model.Usuario;
import projeto.yonder.service.FormularioWriteService;
import projeto.yonder.service.UsuarioService;

@Controller
public class FormularioWriteController {

    @Autowired
    private FormularioWriteService formularioWriteService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/writing/{id}")
    public String formularioWrite(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        FormularioWrite formularioWrite = new FormularioWrite();
        formularioWrite.setUsuario(usuario);
        model.addAttribute("formularioWrite", formularioWrite);
        return "TelaWriting";
    }

    @PostMapping("/writing")
    public String salvar(@ModelAttribute("formularioWrite") FormularioWrite formularioWrite) {
        formularioWrite.setCorrigido(false);
        formularioWriteService.save(formularioWrite);
        return "redirect:/writing/" + formularioWrite.getUsuario().getId();
    }
}