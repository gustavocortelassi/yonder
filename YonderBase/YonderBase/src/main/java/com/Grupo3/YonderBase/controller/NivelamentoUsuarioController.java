package com.Grupo3.YonderBase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Grupo3.YonderBase.model.NivelamentoUsuario;
import com.Grupo3.YonderBase.service.NivelamentoUsuarioService;

@Controller
public class NivelamentoUsuarioController {

    @Autowired
    private NivelamentoUsuarioService nivelamentoUsuarioService;

    @GetMapping("/notas")
    public String mostraNota1(Model model) {
        List<NivelamentoUsuario> notas = nivelamentoUsuarioService.findAll();
        model.addAttribute("niveisId", notas);
        return "TelaVisaoProvas";
    }
}
