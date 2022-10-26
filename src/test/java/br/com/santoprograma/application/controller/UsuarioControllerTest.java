package br.com.santoprograma.application.controller;

import br.com.santoprograma.application.dtos.Usuario.UsuarioPostDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Calendar;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UsuarioControllerTest {

    static final String URL = "/usuarios";

    @Autowired
    MockMvc mvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Test
    void deveRetornar200_quandoExistirUsuariosCadastrados() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get(URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deveRetornar201_quandoCadastrarNovoUsuario() throws Exception {
        UsuarioPostDTO usuarioRequst = criarRequest();

        mvc.perform(MockMvcRequestBuilders
                .post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuarioRequst)))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Inclusão via teste unitario"));
    }

    @Test
    void deveRetornar404_quandoTentarConsultarIdDeUsuarioNaoExistente() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get(URL + "/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Usuário Não encontrado na base de dados"));
    }

    private UsuarioPostDTO criarRequest(){
        UsuarioPostDTO usuarioRequst = new UsuarioPostDTO();

        usuarioRequst.setNome("Inclusão via teste unitario");
        usuarioRequst.setDtNascimento(Calendar.getInstance().getTime());
        usuarioRequst.setTipoLogradouro("Rua");
        usuarioRequst.setLogradouro("Teste");
        usuarioRequst.setNumero("123");
        usuarioRequst.setComplemento("a");
        usuarioRequst.setBairro("Santa");
        usuarioRequst.setCidade("Curitiba");
        usuarioRequst.setCep("82000100");
        usuarioRequst.setUf("PR");
        usuarioRequst.setTelefone("419999-4444");
        usuarioRequst.setEmail("teste2@teste.com.br");
        usuarioRequst.setCpf("26273380058");
        usuarioRequst.setSenha("123");

        return usuarioRequst;
    }
}
