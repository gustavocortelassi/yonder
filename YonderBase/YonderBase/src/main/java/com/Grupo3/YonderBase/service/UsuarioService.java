package com.Grupo3.YonderBase.service;

import org.springframework.stereotype.Service;

import com.Grupo3.YonderBase.model.Usuario;
import com.Grupo3.YonderBase.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
