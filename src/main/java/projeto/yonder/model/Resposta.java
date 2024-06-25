package projeto.yonder.model;

import jakarta.persistence.*;

@Entity
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String titulo;

    private boolean correto;

    private int ordem;

    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Pergunta pergunta;

    public Resposta() {
    }

    public Resposta(Long id, String titulo, boolean correto, int ordem) {
        this.id = id;
        this.titulo = titulo;
        this.correto = correto;
        this.ordem = ordem;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public boolean isCorreto() {
        return correto;
    }


    public void setCorreto(boolean correto) {
        this.correto = correto;
    }


    public int getOrdem() {
        return ordem;
    }


    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }


    public Pergunta getPergunta() {
        return pergunta;
    }


    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

}