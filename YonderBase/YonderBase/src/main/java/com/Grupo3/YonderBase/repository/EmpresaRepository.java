package com.Grupo3.YonderBase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo3.YonderBase.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    List<Empresa> findAll();
}
