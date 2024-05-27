package projeto.yonder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projeto.yonder.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Controller
public class LoginController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/")
    public String showLoginForm() {
        return "TelaLogin";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Query query = entityManager.createNativeQuery("SELECT * FROM Usuario WHERE Nome = ? AND CPF = ?", Usuario.class);
        query.setParameter(1, username);
        query.setParameter(2, password);

        try {
            Usuario usuario = (Usuario) query.getSingleResult();
            return "redirect:/prova";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Usuário ou senha inválidos");
            return "TelaWriting";
        }
    }
}
