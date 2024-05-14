package projeto.yonder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.yonder.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
