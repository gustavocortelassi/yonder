package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpSession;
import projeto.yonder.model.Empresa;
import projeto.yonder.model.Usuario;
import projeto.yonder.service.EmpresaService;
import projeto.yonder.service.UsuarioService;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/cadastro")
    public String mostrarFormularioCadastro(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNotaWriting("");
        usuario.setNotaListening("");
        usuario.setNotaReading("");

        model.addAttribute("usuario", usuario);

        List<Empresa> empresas = empresaService.getAllEmpresas();
        model.addAttribute("empresas", empresas);

        return "TelaCadastrarUsuario";
    }

    @PostMapping("/cadastro")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/regras/" + usuario.getId();
    }

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.getTop50Usuarios();
        model.addAttribute("usuarios", usuarios);
        return "TelaListarUsuarios";
    }
}