package com.Grupo3.YonderBase.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.Grupo3.YonderBase.model.NivelamentoUsuario;
import com.Grupo3.YonderBase.repository.NivelamentoUsuarioRepository;

public class NivelamentoUsuarioService {

@Autowired
private NivelamentoUsuarioRepository nivelamentoUsuarioRepository;

        public Long obternota(Long id) {
        NivelamentoUsuario nivelamentoUsuario = nivelamentoUsuarioRepository.findByLongId(id);
            return nivelamentoUsuario.getNiveisId();

    }
    
}
