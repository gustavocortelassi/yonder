package com.Grupo3.YonderBase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class FormularioRespondido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long corrigido;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Pergunta pergunta;

    public FormularioRespondido() {
    }

    public FormularioRespondido(Long corrigido, Usuario usuario, Pergunta pergunta) {
        this.corrigido = corrigido;
        this.usuario = usuario;
        this.pergunta = pergunta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCorrigido() {
        return corrigido;
    }

    public void setCorrigido(Long corrigido) {
        this.corrigido = corrigido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }
}
