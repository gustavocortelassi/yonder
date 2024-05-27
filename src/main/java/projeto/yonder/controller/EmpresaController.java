package projeto.yonder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projeto.yonder.model.Empresa;
import projeto.yonder.repository.EmpresaRepository;
import projeto.yonder.service.EmpresaService;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/cadastrarEmpresas")
    public String showCadastroForm() {
        return "cadastrar-empresas";
    }

    @GetMapping
    public String listarEmpresas(Model model) {
        List<Empresa> empresas = empresaService.getAllEmpresas();
        model.addAttribute("empresas", empresas);
        return "listar-empresas";
    }

    @PostMapping("/cadastro")
    public String cadastrarEmpresa(@RequestParam("razaoSocial") String razaoSocial,
            @RequestParam("cnpj") String cnpj,
            @RequestParam("cep") String cep,
            @RequestParam("logradouro") String logradouro,
            @RequestParam("bairro") String bairro,
            @RequestParam("numero") Long numero,
            @RequestParam("complemento") String complemento) {

        Empresa empresa = new Empresa(numero, razaoSocial, cnpj, cep, logradouro, bairro, numero, complemento);
        empresaService.save(empresa);
        return "TelaCadastroEmpresas";
    }

    @PostMapping("/excluir/{id}")
    public String excluirEmpresa(@PathVariable("id") Long id) {
        empresaService.excluirEmpresa(id);
        return "redirect:/empresas";
    }

    @GetMapping("/gerenciar-empresas")
    public String gerenciarEmpresas() {
        return "gerenciarEmpresas"; //falta criar essa pagina
    }

<<<<<<< HEAD
    @GetMapping("/home")
=======
    @GetMapping("/usuariosEmpresa")
    public String usersCarac(Model model) {
        return "TelaVisaoUsersEmpresa";
    }

    @GetMapping("/telaDaniel")
>>>>>>> main
    public String home(Model model) {
        List<Empresa> empresas = empresaRepository.findAll();
        model.addAttribute("empresas", empresas);
        return "home";
    }
}