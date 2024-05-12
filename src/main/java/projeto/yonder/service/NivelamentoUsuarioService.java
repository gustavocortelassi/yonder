package projeto.yonder.service;

import java.util.List;

import projeto.yonder.model.NivelamentoUsuario;
import projeto.yonder.repository.NivelamentoUsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class NivelamentoUsuarioService {

    private NivelamentoUsuarioRepository nivelamentoUsuarioRepository;

    public NivelamentoUsuarioService(NivelamentoUsuarioRepository nivelamentoUsuarioRepository) {
        this.nivelamentoUsuarioRepository = nivelamentoUsuarioRepository;
    }

    public List<NivelamentoUsuario> findAll() {
        return nivelamentoUsuarioRepository.findAll();
    }

}
