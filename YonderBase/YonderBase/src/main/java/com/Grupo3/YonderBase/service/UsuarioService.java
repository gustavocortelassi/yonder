package com.Grupo3.YonderBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo3.YonderBase.model.Empresa;
import com.Grupo3.YonderBase.model.Usuario;
import com.Grupo3.YonderBase.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveUsuario(Usuario usuario, Long empresaId) {
        Empresa empresa = new Empresa();
        empresa.setId(empresaId);
        usuario.setEmp(empresa);
        return usuarioRepository.save(usuario);
    }
}
