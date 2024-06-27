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

    @PersistenceContext
    private EntityManager entityManager;

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

    // @GetMapping("/usuarios")
    // public String listarUsuariosNota(Model model) {
    // List<Usuario> usuarios = usuarioService.listarTodos();
    // model.addAttribute("usuarios", usuarios);
    // return "listarUsuarios";
    // }

    // @GetMapping("/usuario/{id}")
    // public String detalhesUsuario(@PathVariable Long id, Model model) {
    // Usuario usuario = usuarioService.buscarPorId(id);
    // if (usuario == null) {
    // return "redirect:/usuarios";
    // }
    // model.addAttribute("usuario", usuario);
    // return "detalhesUsuario";
    // }

    @GetMapping("/login")
    public String showLoginForm() {
        return "TelaLogin"; // Retorna a página de login
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
            @RequestParam("cpf") String cpf,
            Model model,
            HttpSession session) {
        Query query = entityManager.createNativeQuery("SELECT * FROM Usuario WHERE Nome = ? AND CPF = ?",
                Usuario.class);
        query.setParameter(1, username);
        query.setParameter(2, cpf);
        query.setMaxResults(1); // Limita o resultado a um único registro

        try {
            Usuario usuario = (Usuario) query.getSingleResult();
            session.setAttribute("loggedUser", usuario);
            return "redirect:/usuario/detalhes/" + usuario.getId();
        } catch (NoResultException e) {
            model.addAttribute("error", "Usuário ou senha inválidos");
            return "TelaLogin";
        } catch (NonUniqueResultException e) {
            model.addAttribute("error", "Mais de um usuário encontrado. Entre em contato com o suporte.");
            return "TelaLogin";
        }
    }

    @GetMapping("/detalhes/{id}")
    public String detalhesUsuario(@PathVariable Long id, Model model, HttpSession session) {
        Usuario loggedUser = (Usuario) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/usuario/login"; // Redireciona para a página de login se não estiver logado
        }

        Usuario usuario = usuarioService.buscarPorId(id);
        if (usuario == null) {
            return "redirect:/usuario/usuarios"; // Redireciona para a lista de usuários se o ID não for encontrado
        }
        model.addAttribute("usuario", usuario);
        return "detalhesUsuario"; // Página que mostra os detalhes do usuário
    }

}