package projeto.yonder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.yonder.model.FormularioWrite;

@Repository
public interface FormularioWriteRepository extends JpaRepository<FormularioWrite, Long>{
    
    List<FormularioWrite> findAll();
}
