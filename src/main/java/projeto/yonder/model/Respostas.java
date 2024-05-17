package projeto.yonder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Respostas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Titulo;
    private boolean Correto;
    private int Ordem;
    
    @ManyToOne
    @JoinColumn(name = "perguntas_id")
    private Pergunta pergunta;
    
    public Respostas() {
    }


    public Respostas(int id, String titulo, boolean correto, int ordem) {
        Id = id;
        Titulo = titulo;
        Correto = correto;
        Ordem = ordem;
    }


    public int getId() {
        return Id;
    }


    public void setId(int id) {
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
   
    
}
