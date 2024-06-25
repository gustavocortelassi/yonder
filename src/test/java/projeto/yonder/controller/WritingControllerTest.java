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

@WebMvcTest(WritingController.class)
public class WritingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WritingService writingService;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    public void testSalvar() throws Exception {
        Long userId = 1L;
        Usuario usuario = new Usuario();
        usuario.setId(userId);
        when(usuarioService.getUsuarioById(userId)).thenReturn(usuario);

        mockMvc.perform(MockMvcRequestBuilders.post("/writing/{id}", userId)
                        .param("corrigido", "false")
                        .param("correcao", "")
                        .param("notaWriting", ""))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/correcao/" + userId));

        Mockito.verify(writingService, Mockito.times(1)).save(any(Writing.class));
    }
}