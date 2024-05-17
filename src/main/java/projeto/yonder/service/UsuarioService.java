package projeto.yonder.service;

import projeto.yonder.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.yonder.model.Usuario;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // salva no banco
    public void salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    // lista
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // busca por id
    public Usuario getUsuarioById(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.orElse(null);
    }

    // deleta por id
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
