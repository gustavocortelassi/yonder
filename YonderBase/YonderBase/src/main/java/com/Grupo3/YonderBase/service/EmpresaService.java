package com.Grupo3.YonderBase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo3.YonderBase.model.Empresa;
import com.Grupo3.YonderBase.repository.EmpresaRepository;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa save(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public List<Empresa> findAll(){
        return empresaRepository.findAll();
    }
}
