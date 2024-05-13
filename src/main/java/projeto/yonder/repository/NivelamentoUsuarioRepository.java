package projeto.yonder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.yonder.model.NivelamentoUsuario;

@Repository
public interface NivelamentoUsuarioRepository extends JpaRepository<NivelamentoUsuario, Long>{

    List<NivelamentoUsuario> findAll();
}
