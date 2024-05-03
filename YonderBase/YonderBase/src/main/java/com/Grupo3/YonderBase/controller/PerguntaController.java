package com.Grupo3.YonderBase.controller;

import com.Grupo3.YonderBase.model.Pergunta;
import com.Grupo3.YonderBase.repository.PerguntaRepository;
import com.Grupo3.YonderBase.service.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@Controller
public class PerguntaController {

    @Autowired
    PerguntaRepository perguntaRepository;
    @Autowired
    PerguntaService perguntaService;

    @GetMapping("/pergunta")
    public String showList(Model model, @RequestParam (defaultValue="0") int page) {
        model.addAttribute("data", perguntaRepository.findAll( PageRequest.of(page, 5, Sort.by(
                Sort.Order.asc("id")))));
        model.addAttribute("currentPage", page);
        return "visualizarPerguntas";
    }

    @PostMapping("/savePergunta")
    public String saveAddPergunta (Pergunta pergunta) {
        perguntaRepository.save(pergunta);
        return "redirect:/pergunta";
    }


    @DeleteMapping("pergunta/delete/{id}")
    public ResponseEntity<?> excluirPergunta(@PathVariable Long id) {
        try {
            perguntaService.excluirPergunta(id);
            return ResponseEntity.ok().build(); // Retorna 200 OK se a exclusão for bem-sucedida
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir a pergunta"); // Retorna 500 Internal Server Error se ocorrer um erro
        }
    }

    @PutMapping("/pergunta/editar/{id}")
    @ResponseBody
    public String editarPergunta(@PathVariable("id") Long perguntaId,
                                 @RequestParam("cabecalho") String cabecalho,
                                 @RequestParam("dificuldade") long dificuldade,
                                 @RequestParam("tipoProvaId") String tipoProvaId,
                                 @RequestParam("niveisId") long niveisId,
                                 @RequestParam("audio") String audio) {
        perguntaService.editarPergunta(perguntaId, cabecalho, dificuldade, tipoProvaId, niveisId, audio);
        return "Pergunta editada com sucesso!";
    }

}

