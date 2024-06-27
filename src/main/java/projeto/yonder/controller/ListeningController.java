package projeto.yonder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projeto.yonder.model.Pergunta;
import projeto.yonder.model.Resposta;
import projeto.yonder.model.Usuario;
import projeto.yonder.repository.PerguntaRepository;
import projeto.yonder.repository.RespostasRepository;
import projeto.yonder.repository.UsuarioRepository;

@Controller
@RequestMapping("/provaListening/{userId}")
public class ListeningController {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private RespostasRepository respostasRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final int TOTAL_PERGUNTAS = 10;

    @GetMapping("/listening/{perguntaId}")
    public String exibirFormulario(@PathVariable("userId") Long userId, @PathVariable("perguntaId") Long perguntaId,
                                   @RequestParam(value = "contador", defaultValue = "0") int contador, Model model) {
        Pergunta pergunta = perguntaRepository.findById(perguntaId).orElse(null);

        if (pergunta != null) {
            model.addAttribute("pergunta", pergunta);
            model.addAttribute("respostas", pergunta.getResposta());
            model.addAttribute("userId", userId);
            model.addAttribute("proximaPerguntaId", perguntaId);
            model.addAttribute("contador", contador);

            // Extrair o ID do vídeo do YouTube
            String videoId = extrairVideoId(pergunta.getAudio());
            model.addAttribute("videoId", videoId);
        } else {
            model.addAttribute("mensagem", "Não há mais perguntas disponíveis.");
            return "TelaResultado";
        }

        return "TelaProvaListening";
    }

    private String extrairVideoId(String url) {
        String videoId = "";
        if (url != null && url.contains("youtube.com")) {
            String[] parts = url.split("v=");
            if (parts.length > 1) {
                String[] params = parts[1].split("&");
                videoId = params[0];
            }
        }
        return videoId;
    }

    @PostMapping("/listening/{perguntaId}")
    public String processarFormulario(@PathVariable("userId") Long userId, @PathVariable("perguntaId") Long perguntaId, @RequestParam("resposta") Long respostaId, @RequestParam("contador") int contador) {
        contador++;
        Resposta resposta = respostasRepository.findById(respostaId).orElse(null);
        Pergunta pergunta = perguntaRepository.findById(perguntaId).orElse(null);

        if (resposta != null && pergunta != null && resposta.isCorreto()) {
            Usuario usuario = usuarioRepository.findById(userId).orElse(null);
            if (usuario != null) {
                usuario.setRespostasCorretas(usuario.getRespostasCorretas() + 1);
                usuarioRepository.save(usuario);
            }
        }

        if (contador >= TOTAL_PERGUNTAS) {
            return "redirect:/listening/" + userId + "/resultado";
        }

        return "redirect:/listening/" + userId + "/listening/" + (perguntaId + 1) + "?contador=" + contador;
    }

    @GetMapping("/resultado")
    public String exibirResultado(@PathVariable("userId") Long userId, Model model) {
        Usuario usuario = usuarioRepository.findById(userId).orElse(null);
        if (usuario != null) {
            String classificacao = calcularClassificacao(usuario.getRespostasCorretas());
            usuario.setClassificacao(classificacao);

            double nota = calcularNota(usuario.getRespostasCorretas());
            usuario.setNota(nota);

            usuarioRepository.save(usuario);

            model.addAttribute("nota", usuario.getNota());
            model.addAttribute("classificacao", usuario.getClassificacao());
        } else {
            model.addAttribute("mensagem", "Usuário não encontrado.");
        }

        return "TelaResultado";
    }

    private String calcularClassificacao(int respostasCorretas) {
        if (respostasCorretas <= 2) {
            return "A1";
        } else if (respostasCorretas <= 4) {
            return "A2";
        } else if (respostasCorretas <= 6) {
            return "B1";
        } else if (respostasCorretas <= 8) {
            return "B2";
        } else if (respostasCorretas <= 10) {
            return "C1";
        } else {
            return "C2";
        }
    }

    private double calcularNota(int respostasCorretas) {
        return (double) respostasCorretas / TOTAL_PERGUNTAS * 10; // Nota de 0 a 10
    }
}
