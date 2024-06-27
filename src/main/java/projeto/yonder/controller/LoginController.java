package projeto.yonder.controller;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projeto.yonder.model.Usuario;
import projeto.yonder.service.UsuarioService;

@Controller
public class LoginController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "TelaLogin";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("cpf") String cpf,
                        Model model,
                        HttpSession session) {
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM Usuario WHERE Nome = ? AND CPF = ?",
                    Usuario.class);
            query.setParameter(1, username);
            query.setParameter(2, cpf);
            query.setMaxResults(1);

            Usuario usuario = (Usuario) query.getSingleResult();
            session.setAttribute("usuario", usuario);

            return "redirect:/detalhes/" + usuario.getId();
        } catch (NoResultException e) {
            model.addAttribute("error", "Usuário ou senha inválidos");
            return "TelaLogin";
        }
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            model.addAttribute("error", "Usuário não encontrado");
            return "TelaLogin";
        }
        model.addAttribute("usuario", usuario);
        return "TelaDetalhes";
    }
}