package projeto.yonder.service;

import projeto.yonder.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import projeto.yonder.model.Usuario;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> getTop50Usuarios() {
        return usuarioRepository.findTop50ByOrderByIdAsc();
    }

    public Usuario getUsuarioById(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.orElse(null);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> listarTodos() {
        Pageable pageable = PageRequest.of(0, 50);
        return usuarioRepository.findAll(pageable).getContent();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
