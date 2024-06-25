package projeto.yonder.model;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String notaWriting;

    private String notaReading;

    private String notaListening;

    @Column(columnDefinition = "TEXT")
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = true)
    private Empresa empresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNotaWriting() {
        return notaWriting;
    }

    public void setNotaWriting(String notaWriting) {
        this.notaWriting = notaWriting;
    }

    public String getNotaReading() {
        return notaReading;
    }

    public void setNotaReading(String notaReading) {
        this.notaReading = notaReading;
    }

    public String getNotaListening() {
        return notaListening;
    }

    public void setNotaListening(String notaListening) {
        this.notaListening = notaListening;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
