package projeto.yonder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.yonder.model.FormularioRespondido;

@Repository
public interface FormularioRespondidoRepository extends JpaRepository<FormularioRespondido, Long>{
    
}
