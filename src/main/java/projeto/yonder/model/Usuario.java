package projeto.yonder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;
        private String Nome;
        private String Cpf;
    
        @ManyToOne
        @JoinColumn(name = "emp_id", nullable = true)
        private Empresa empresa;

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

        public String getCpf() {
            return Cpf;
        }

        public void setCpf(String cpf) {
            Cpf = cpf;
        }

        public Empresa getEmpresa() {
            return empresa;
        }

        public void setEmpresa(Empresa empresa) {
            this.empresa = empresa;
        }

}