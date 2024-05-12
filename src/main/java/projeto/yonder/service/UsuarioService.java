package projeto.yonder.service;

import projeto.yonder.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import projeto.yonder.model.Usuario;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
