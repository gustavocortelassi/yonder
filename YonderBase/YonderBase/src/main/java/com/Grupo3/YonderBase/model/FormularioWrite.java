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
    private Long id;
    private String resposta;
    private Long corrigido;

    @OneToOne
    private FormularioRespondido formResp;

    public FormularioWrite() {
    }

    public FormularioWrite(String resposta, Long corrigido, FormularioRespondido formResp) {
        this.resposta = resposta;
        this.corrigido = corrigido;
        this.formResp = formResp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Long getCorrigido() {
        return corrigido;
    }

    public void setCorrigido(Long corrigido) {
        this.corrigido = corrigido;
    }

    public FormularioRespondido getFormResp() {
        return formResp;
    }

    public void setFormResp(FormularioRespondido formResp) {
        this.formResp = formResp;
    }
}
