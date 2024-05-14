package projeto.yonder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.yonder.model.Pergunta;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{
    
}
