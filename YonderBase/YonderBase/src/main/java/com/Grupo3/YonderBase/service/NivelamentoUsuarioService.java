
package com.Grupo3.YonderBase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Grupo3.YonderBase.model.NivelamentoUsuario;
import com.Grupo3.YonderBase.repository.NivelamentoUsuarioRepository;

@Service
public class NivelamentoUsuarioService {

    private NivelamentoUsuarioRepository nivelamentoUsuarioRepository;

    public NivelamentoUsuarioService(NivelamentoUsuarioRepository nivelamentoUsuarioRepository) {
        this.nivelamentoUsuarioRepository = nivelamentoUsuarioRepository;
    }

    public List<NivelamentoUsuario> findAll() {
        return nivelamentoUsuarioRepository.findAll();
    }

}
