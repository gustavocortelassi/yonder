package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import projeto.yonder.model.Usuario;
import projeto.yonder.service.UsuarioService;

@Controller
public class RegrasController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/regras/{id}")
    public String regras(@PathVariable Long id, Model model) {
    Usuario usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("id", id);
        return "TelaRegras";
    }
}