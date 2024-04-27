package com.Grupo3.YonderBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo3.YonderBase.model.Usuario;
import com.Grupo3.YonderBase.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrarUsuario")
    public ModelAndView cadastrarUsuario(@ModelAttribute Usuario usuario, @RequestParam Long empresaId) {
    ModelAndView modelAndView = new ModelAndView();
    usuarioService.saveUsuario(usuario, empresaId);
    modelAndView.setViewName("registroSucesso");
    return modelAndView;
}

    @GetMapping("/registroSucesso")
    public String getRegistroSucesso() {
    return "registroSucesso";
}
}
