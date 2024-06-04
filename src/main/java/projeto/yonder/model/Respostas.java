package projeto.yonder.model;

import jakarta.persistence.*;


@Entity
public class Respostas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(columnDefinition = "TEXT")
    private String Titulo;
    private boolean Correto;
    private int Ordem;
    
    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Pergunta pergunta;
    
    public Respostas() {
    }

    public Respostas(Long id, String titulo, boolean correto, int ordem) {
        Id = id;
        Titulo = titulo;
        Correto = correto;
        Ordem = ordem;
    }


    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
    }


    public String getTitulo() {
        return Titulo;
    }


    public void setTitulo(String titulo) {
        Titulo = titulo;
    }


    public boolean isCorreto() {
        return Correto;
    }


    public void setCorreto(boolean correto) {
        Correto = correto;
    }


    public int getOrdem() {
        return Ordem;
    }


    public void setOrdem(int ordem) {
        Ordem = ordem;
    }


    public Pergunta getPergunta() {
        return pergunta;
    }


    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    } 
    
}
