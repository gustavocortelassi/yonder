package projeto.yonder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projeto.yonder.model.Empresa;
import projeto.yonder.model.Usuario;
import projeto.yonder.service.EmpresaService;
import projeto.yonder.service.UsuarioService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "listar-usuarios";
    }

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastrar-usuarios";
    }

    @PostMapping("/cadastrarUsuario")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario, Model model) {
        usuarioService.salvar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/formlogin")
    public String showLoginForm() {
        return "login"; 
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Query query = entityManager.createNativeQuery("SELECT * FROM Usuario WHERE Nome = ? AND CPF = ?", Usuario.class);
        query.setParameter(1, username);
        query.setParameter(2, password);

        try {
            Usuario usuario = (Usuario) query.getSingleResult();
            // Usuário autenticado
            return "redirect:/usuarios"; // Redirecionar para a página de home
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Usuário ou senha inválidos");
            return "login"; // Retornar para a página de login com mensagem de erro
        }
    }

}
