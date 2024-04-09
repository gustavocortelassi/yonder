package com.Grupo3.YonderBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo3.YonderBase.model.Empresa;
import com.Grupo3.YonderBase.repository.EmpresaRepository;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;
    
    // public void cadastrarEmpresa(Empresa empresa){
    //     empresaRepository.save(empresa);
    // }

    public void cadastrarEmpresaComValoresPadrao() {
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial("Empresa Teste");
        empresa.setCNPJ("12345678901234");
        empresa.setCEP("12345678");
        empresa.setLogradouro("Rua Teste");
        empresa.setBairro("Bairro Teste");
        empresa.setNumero(123L);
        empresa.setComplemento("Complemento Teste");

        
        empresaRepository.save(empresa);
    }
}
