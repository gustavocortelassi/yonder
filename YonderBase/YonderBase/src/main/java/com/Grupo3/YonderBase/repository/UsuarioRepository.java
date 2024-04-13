package com.Grupo3.YonderBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Grupo3.YonderBase.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
