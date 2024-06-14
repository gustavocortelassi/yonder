package projeto.yonder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.yonder.model.Respostas;

@Repository
public interface RespostasRepository extends JpaRepository<Respostas, Long>{

    
}
