package projeto.yonder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import projeto.yonder.model.Empresa;
import projeto.yonder.repository.EmpresaRepository;

@Controller
public class HomeController {
    
     private final EmpresaRepository empresaRepository;

    @Autowired
    public HomeController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Empresa> empresas = empresaRepository.findAll();
        model.addAttribute("empresas", empresas);
        return "home";
    }
}

