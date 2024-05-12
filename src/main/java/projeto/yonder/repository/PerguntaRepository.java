package projeto.yonder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.yonder.model.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{
    
}
