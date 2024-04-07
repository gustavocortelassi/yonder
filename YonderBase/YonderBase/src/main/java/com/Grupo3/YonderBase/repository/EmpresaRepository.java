package com.Grupo3.YonderBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Grupo3.YonderBase.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    
}
