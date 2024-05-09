package com.Grupo3.YonderBase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo3.YonderBase.model.NivelamentoUsuario;

@Repository
public interface NivelamentoUsuarioRepository extends JpaRepository<NivelamentoUsuario, Long>{

    List<NivelamentoUsuario> findAll();
    
}
