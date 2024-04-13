package com.Grupo3.YonderBase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class FormularioWrite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Resposta;
    private Long Corrigido;

    @OneToOne
    private FormularioRespondido FormResp;

    public FormularioWrite() {
    }

    public FormularioWrite(String resposta, Long corrigido, FormularioRespondido formResp) {
        this.Resposta = resposta;
        this.Corrigido = corrigido;
        this.FormResp = formResp;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getResposta() {
        return Resposta;
    }

    public void setResposta(String resposta) {
        this.Resposta = resposta;
    }

    public Long getCorrigido() {
        return Corrigido;
    }

    public void setCorrigido(Long corrigido) {
        this.Corrigido = corrigido;
    }

    public FormularioRespondido getFormResp() {
        return FormResp;
    }

    public void setFormResp(FormularioRespondido formResp) {
        this.FormResp = formResp;
    }
}
