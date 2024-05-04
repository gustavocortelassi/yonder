package com.Grupo3.YonderBase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String RazaoSocial;
    private String CNPJ;
    private String CEP;
    private String Logradouro;
    private String Bairro;
    private Long Numero;
    private String Complemento;

    public Empresa() {
    }

    public Empresa(String razaoSocial, String cnpj, String cep, String logradouro, String bairro, Long numero,
            String complemento) {
        this.RazaoSocial = razaoSocial;
        this.CNPJ = cnpj;
        this.CEP = cep;
        this.Logradouro = logradouro;
        this.Bairro = bairro;
        this.Numero = numero;
        this.Complemento = complemento;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.RazaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String cnpj) {
        this.CNPJ = cnpj;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String cep) {
        this.CEP = cep;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.Logradouro = logradouro;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        this.Bairro = bairro;
    }

    public Long getNumero() {
        return Numero;
    }

    public void setNumero(Long numero) {
        this.Numero = numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        this.Complemento = complemento;
    }
}
