package com.Grupo3.YonderBase.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Grupo3.YonderBase.model.NivelamentoUsuario;

public interface NivelamentoUsuarioRepository extends JpaRepository<NivelamentoUsuario, Long>{

    Optional<NivelamentoUsuario> findByUserIdandTipoProva (Long user,Long TipoProvaId);
    
}
