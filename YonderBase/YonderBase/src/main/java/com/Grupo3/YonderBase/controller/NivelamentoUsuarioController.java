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
    public String mostraNota1(NivelamentoUsuario nivelamentoUsuario) {
        Long user = (long) 1;
        Long tipoProvaId =(long) 1;
        nivelamentoUsuario.addAttribute("niveisId", nivelamentoUsuarioRepository.findByUserIdandTipoProva(user,tipoProvaId));
        return "TelaVisaoProvas";
    }
    @GetMapping("/notas")
    public String mostraNota2(NivelamentoUsuario nivelamentoUsuario) {
        Long user = (long) 1;
        Long tipoProvaId =(long) 2;
        nivelamentoUsuario.addAttribute("niveisId", nivelamentoUsuarioRepository.findByUserIdandTipoProva(user,tipoProvaId));
        return "TelaVisaoProvas";
    }
    @GetMapping("/notas")
    public String mostraNota3(NivelamentoUsuario nivelamentoUsuario) {
        Long user = (long) 1;
        Long tipoProvaId =(long) 3;
        nivelamentoUsuario.addAttribute("niveisId", nivelamentoUsuarioRepository.findByUserIdandTipoProva(user,tipoProvaId));
        return "TelaVisaoProvas";
    }
    @GetMapping("/notas")
    public String mostraNota4(NivelamentoUsuario nivelamentoUsuario) {
        Long user = (long) 1;
        Long tipoProvaId =(long) 4;
        nivelamentoUsuario.addAttribute("niveisId", nivelamentoUsuarioRepository.findByUserIdandTipoProva(user,tipoProvaId));
        return "TelaVisaoProvas";
    }

    @GetMapping("/notas")
    public String verificaCorrecao(NivelamentoUsuario nivelamentoUsuario){
        nivelamentoUsuario.addAttribute("corrigido",nivelamentoUsuarioRepository.findBy)
    }


     //verificar correção write:
 //   if corrigido = 1 -> corrigido
   // if corrigido = 2 -> não corrigido
    //if corrigido = 3 -> em analise

    
}
