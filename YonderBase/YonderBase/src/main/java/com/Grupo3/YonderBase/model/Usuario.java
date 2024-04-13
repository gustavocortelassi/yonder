package com.Grupo3.YonderBase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;
        private String Nome;
        private String CPF;
    
        @ManyToOne
        private Empresa Emp;
    
        public Usuario() {
        }
    
        public Usuario(Long id, String nome, String CPF, Empresa emp) {
            Id = id;
            Nome = nome;
            this.CPF = CPF;
            Emp = emp;
        }
    
        public Long getId() {
            return Id;
        }
    
        public void setId(Long id) {
            Id = id;
        }
    
        public String getNome() {
            return Nome;
        }
    
        public void setNome(String nome) {
            Nome = nome;
        }
    
        public String getCPF() {
            return CPF;
        }
    
        public void setCPF(String CPF) {
            this.CPF = CPF;
        }
    
        public Empresa getEmp() {
            return Emp;
        }
    
        public void setEmp(Empresa emp) {
            Emp = emp;
        }
}
