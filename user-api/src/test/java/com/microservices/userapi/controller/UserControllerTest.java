package com.microservices.userapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.userapi.model.User;
import com.microservices.userapi.model.dto.UserDTO;
import com.microservices.userapi.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {UserController.class})
@AutoConfigureMockMvc
public class UserControllerTest {

    static String USER_API = "/users";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("Deve criar um novo usuário")
    void saveNewUser() throws Exception {
        //JSON Request
        UserDTO userDTO = createNewBook();

        //JSON Response
        User user = returnJsonUser();

        // Save na entidade book e retorna o valor que foi salvo com sucesso.
        BDDMockito.given(userService.save(Mockito.any(UserDTO.class))).willReturn(userDTO);
        String json = new ObjectMapper().writeValueAsString(user);

        // Cria a requisição post, setando um json no conteudo da request
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(USER_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        // Assertivas dos testes, passando o que espero receber como resposta
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated()) //status da requisição: 201 Created
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(1L)) // Espero um id não vazio
                .andExpect(MockMvcResultMatchers.jsonPath("nome").value(user.getNome()))
                .andExpect(MockMvcResultMatchers.jsonPath("cpf").value(user.getCpf()))
                .andExpect(MockMvcResultMatchers.jsonPath("email").value(user.getEmail()))
                .andExpect(MockMvcResultMatchers.jsonPath("endereco").value(user.getEndereco()))
                .andExpect(MockMvcResultMatchers.jsonPath("telefone").value(user.getTelefone()));
    }

    private UserDTO createNewBook() {
        UserDTO user = new UserDTO();
        user.setNome("Mateus");
        user.setCpf("000.000.000-00");
        user.setEmail("teste2email.com");
        user.setEndereco("Rua dos Devs");
        user.setTelefone("00 1111-2222");

        return user;
    }

    private User returnJsonUser() {
        User user = new User();
        user.setId(1L);
        user.setNome("Mateus");
        user.setCpf("000.000.000-00");
        user.setEmail("teste2email.com");
        user.setEndereco("Rua dos Devs");
        user.setTelefone("00 1111-2222");

        return user;
    }
}
