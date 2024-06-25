package projeto.yonder.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import projeto.yonder.model.Writing;
import projeto.yonder.model.Usuario;
import projeto.yonder.service.WritingService;
import projeto.yonder.service.UsuarioService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(CorrecaoController.class)
public class CorrecaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WritingService writingService;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    public void testGetCorrecao() throws Exception {
        Long userId = 1L;
        Usuario usuario = new Usuario();
        usuario.setId(userId);
        usuario.setNome("João");
        Writing writing = new Writing();
        writing.setUsuario(usuario);
        when(writingService.findById(userId)).thenReturn(writing);

        mockMvc.perform(MockMvcRequestBuilders.get("/correcao/{id}", userId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("TelaCorrecaoProva"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("writing"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("id"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("nome"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("notaWriting"))
                .andExpect(MockMvcResultMatchers.model().attribute("nome", "João"))
                .andExpect(MockMvcResultMatchers.model().attribute("notaWriting", "10"));
    }

    @Test
    public void testPostCorrecaoWriting() throws Exception {
        Long userId = 1L;
        Writing writing = new Writing();
        writing.setCorrecao("Nova correcao");
        String notaSelecionada = "8";

        when(writingService.findById(userId)).thenReturn(writing);

        mockMvc.perform(MockMvcRequestBuilders.post("/correcaowriting/{id}", userId)
                        .param("notaSelecionada", notaSelecionada)
                        .flashAttr("writing", writing))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/correcao/" + userId));

        Mockito.verify(writingService, Mockito.times(1)).save(any(Writing.class));
    }

    @Test
    public void testSalvarFeedback() throws Exception {
        Long userId = 1L;
        Writing writing = new Writing();
        Usuario usuario = new Usuario();
        usuario.setFeedback("Novo feedback");
        writing.setUsuario(usuario);

        when(writingService.findById(userId)).thenReturn(writing);

        mockMvc.perform(MockMvcRequestBuilders.post("/salvarFeedback/{id}", userId)
                        .flashAttr("writing", writing))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/correcao/" + userId));

        Mockito.verify(writingService, Mockito.times(1)).save(any(Writing.class));
    }
}