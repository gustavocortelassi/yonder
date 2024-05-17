package projeto.yonder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.yonder.model.FormularioWrite;
import projeto.yonder.repository.FormularioWriteRepository;

import java.util.List;

@Service
public class FormularioWriteService {

    @Autowired
    private FormularioWriteRepository formularioWriteRepository;

    public void save(FormularioWrite formularioWrite) {
        formularioWriteRepository.save(formularioWrite);
    }

    public FormularioWrite findById(Long id) {
        return formularioWriteRepository.findById(id).orElse(null);
    }
}
