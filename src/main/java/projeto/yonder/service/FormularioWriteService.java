package projeto.yonder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.yonder.model.FormularioWrite;
import projeto.yonder.repository.FormularioWriteRepository;

@Service
public class FormularioWriteService {

    @Autowired
    private FormularioWriteRepository formularioWriteRepository;

    @Autowired
    public FormularioWriteService(FormularioWriteRepository formularioWriteRepository) {
        this.formularioWriteRepository = formularioWriteRepository;
    }

    public FormularioWrite findById(Long id) {
        return formularioWriteRepository.findById(id).orElse(null);
    }

    public void save(FormularioWrite formularioWrite) {
        formularioWriteRepository.save(formularioWrite);
    }
}

