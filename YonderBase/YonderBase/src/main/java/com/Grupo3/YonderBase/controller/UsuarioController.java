package com.Grupo3.YonderBase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Grupo3.YonderBase.model.Empresa;
import com.Grupo3.YonderBase.model.Usuario;
import com.Grupo3.YonderBase.service.UsuarioService;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/novo")
    public String exibirFormularioNovoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registroUsuario";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute Usuario usuario, @RequestParam Long empresaId) {
        Empresa empresa = new Empresa();
        empresa.setId(empresaId);
        usuario.setEmpresa(empresa);
        usuarioService.salvarUsuario(usuario);
        return "redirect:/registroSucesso";
    }    

    @GetMapping("/registroSucesso")
    public String exibirRegistroSucesso() {
        return "registroSucesso";
    }
}
