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
        Long user = (long) 1;
        Long tipoProvaId =(long) 1;
        nivelamentoUsuario.addAttribute("niveisId", nivelamentoUsuarioRepository.findByUserIdandTipoProva(user,tipoProvaId));
        return "TelaVisaoProvas";
    }

    
}
