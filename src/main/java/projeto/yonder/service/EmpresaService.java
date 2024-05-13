package projeto.yonder.service;

import java.util.List;
import java.util.Optional;

import projeto.yonder.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import projeto.yonder.model.Empresa;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }

    //  buscar uma empresa por ID
    public Empresa findById(Long id) {
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
        return optionalEmpresa.orElse(null);
    }
}
