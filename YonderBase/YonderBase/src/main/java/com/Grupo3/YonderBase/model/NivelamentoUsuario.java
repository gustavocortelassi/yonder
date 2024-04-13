package com.Grupo3.YonderBase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;


@Entity
public class NivelamentoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long NiveisId;
    private Long TipoProvaId;

    @ManyToOne
    private Usuario User;

    public NivelamentoUsuario() {
    }

    public NivelamentoUsuario(Long id, Long niveisId, Long tipoProvaId, Usuario user) {
        Id = id;
        NiveisId = niveisId;
        TipoProvaId = tipoProvaId;
        User = user;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getNiveisId() {
        return NiveisId;
    }

    public void setNiveisId(Long niveisId) {
        NiveisId = niveisId;
    }

    public Long getTipoProvaId() {
        return TipoProvaId;
    }

    public void setTipoProvaId(Long tipoProvaId) {
        TipoProvaId = tipoProvaId;
    }

    public Usuario getUser() {
        return User;
    }

    public void setUser(Usuario user) {
        User = user;
    }
}