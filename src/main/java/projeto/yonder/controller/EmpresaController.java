package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.yonder.model.Empresa;
import projeto.yonder.service.EmpresaService;

import java.util.List;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/cadastro")
    public String mostrarFormularioCadastro(Model model) {
        List<Empresa> empresas = empresaService.getAllEmpresas();
        model.addAttribute("empresas", empresas);
        return "TelaCadastrarEmpresa";
    }

    @PostMapping("/cadastro")
    public String cadastrarEmpresa(@ModelAttribute Empresa empresa) {
        empresaService.save(empresa);
        return "redirect:/empresas";
    }

    @GetMapping
    public String listarEmpresas(Model model) {
        List<Empresa> empresas = empresaService.getAllEmpresas();
        if (empresas.size() > 50) {
            empresas = empresas.subList(0, 50);
        }
        model.addAttribute("empresas", empresas);
        return "TelaListarEmpresas";
    }

    @PostMapping("/excluir/{id}")
    public String excluirEmpresa(@PathVariable("id") Long id) {
        empresaService.excluirEmpresa(id);
        return "redirect:/empresas";
    }
}