package projeto.yonder.service;

import java.util.List;

import projeto.yonder.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import projeto.yonder.model.Empresa;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    // metodo para salvar
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    // metodo para excluir
    public void excluirEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }

    // metodo para listar
    public List<Empresa> getAllEmpresas(){
        return empresaRepository.findAll();
    }

}
