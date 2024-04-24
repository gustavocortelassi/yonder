package com.Grupo3.YonderBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo3.YonderBase.model.NivelamentoUsuario;
import com.Grupo3.YonderBase.repository.NivelamentoUsuarioRepository;

@RestController
public class NivelamentoUsuarioController {



        @Autowired
    private NivelamentoUsuarioRepository nivelamentoUsuarioRepository;

    @GetMapping("/notas")
    public String mostraNota(NivelamentoUsuario nivelamentoUsuario) {
        Long Id = (long) 1;
        Long TipoProvaId =(long) 1;
        nivelamentoUsuario.addAttribute("NiveisId", nivelamentoUsuarioRepository.findByIdandTipoProva(Id,TipoProvaId));
        return "TelaVisaoProvas";
    }

    
}
