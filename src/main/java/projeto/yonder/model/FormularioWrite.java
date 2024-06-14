package projeto.yonder.model;

import jakarta.persistence.*;

@Entity
public class FormularioWrite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(columnDefinition = "TEXT")
    private String resposta;
    @Column(columnDefinition = "TEXT")
    private String correcao;
    private String notaWriting;
    private boolean corrigido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getCorrecao() {
        return correcao;
    }

    public void setCorrecao(String correcao) {
        this.correcao = correcao;
    }

    public String getNotaWriting() {
        return notaWriting;
    }

    public void setNotaWriting(String notaWriting) {
        this.notaWriting = notaWriting;
    }

    public boolean isCorrigido() {
        return corrigido;
    }

    public void setCorrigido(boolean corrigido) {
        this.corrigido = corrigido;
    }
}