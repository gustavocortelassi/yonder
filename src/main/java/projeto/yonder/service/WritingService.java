package projeto.yonder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.yonder.model.Writing;
import projeto.yonder.repository.FormularioWriteRepository;

@Service
public class WritingService {

    @Autowired
    private FormularioWriteRepository formularioWriteRepository;

    @Autowired
    public WritingService(FormularioWriteRepository formularioWriteRepository) {
        this.formularioWriteRepository = formularioWriteRepository;
    }

    public Writing findById(Long id) {
        return formularioWriteRepository.findById(id).orElse(null);
    }

    public void save(Writing writing) {
        formularioWriteRepository.save(writing);
    }
}

