package com.Grupo3.YonderBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo3.YonderBase.service.NivelamentoUsuarioService;

@RestController
public class NivelamentoUsuarioController {



        @Autowired
    private NivelamentoUsuarioService nivusser;


    Long id = (long) 1;


    @GetMapping("/notas")
    public Long mostranota(@PathVariable Long id) {
        
        return nivusser.obternota(id);
    }


    
}
