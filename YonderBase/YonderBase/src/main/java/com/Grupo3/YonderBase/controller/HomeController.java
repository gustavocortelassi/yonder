package com.Grupo3.YonderBase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    // Modificar aqui para acessar as paginas
    @GetMapping("/")
    public String index() {
        return "listaUsuarios";
    }
}
