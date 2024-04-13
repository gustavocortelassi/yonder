package com.Grupo3.YonderBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo3.YonderBase.service.EmpresaService;

@RestController
public class EmpresaController {
    
    @Autowired
    private EmpresaService empresaService;
    
    @PostMapping("/empresas")
    public String cadastrarEmpresaComValoresPadrao() {
        empresaService.cadastrarEmpresaComValoresPadrao();
        return "Empresa cadastrada com valores padrão!";
    }

}
