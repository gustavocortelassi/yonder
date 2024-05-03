package com.Grupo3.YonderBase.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Grupo3.YonderBase.model.FormularioWrite;

public interface FormularioWriteRepository extends JpaRepository<FormularioWrite, Long>{
    
    Optional<FormularioWrite> findByIdFormres (Long formResp);

}
