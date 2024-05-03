package com.Grupo3.YonderBase.model;

import jakarta.persistence.*;


@Entity
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Cabecalho;
    private Long Dificuldade;
    private String TipoProvaId;
    private Long NiveisId;
    private String Audio;

    public Pergunta() {
    }

    public Pergunta(Long id, String cabecalho, Long dificuldade, String tipoProvaId, Long niveisId, String audio) {
        Id = id;
        Cabecalho = cabecalho;
        Dificuldade = dificuldade;
        TipoProvaId = tipoProvaId;
        NiveisId = niveisId;
        Audio = audio;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCabecalho() {
        return Cabecalho;
    }

    public void setCabecalho(String cabecalho) {
        Cabecalho = cabecalho;
    }

    public Long getDificuldade() {
        return Dificuldade;
    }

    public void setDificuldade(Long dificuldade) {
        Dificuldade = dificuldade;
    }

    public String getTipoProvaId() {
        return TipoProvaId;
    }

    public void setTipoProvaId(String tipoProvaId) {
        TipoProvaId = tipoProvaId;
    }

    public Long getNiveisId() {
        return NiveisId;
    }

    public void setNiveisId(Long niveisId) {
        NiveisId = niveisId;
    }

    public String getAudio() {
        return Audio;
    }

    public void setAudio(String audio) {
        Audio = audio;
    }
}
