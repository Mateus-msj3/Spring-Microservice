package com.microservices.userapi.service;

import com.microservices.userapi.model.User;
import com.microservices.userapi.model.dto.UserDTO;
import com.microservices.userapi.repository.UserRepository;
import com.microservices.userapi.service.implementation.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UserServiceTest {

    UserService userService;

    @MockBean
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        this.userService = new UserServiceImpl(userRepository);
    }

    @Test
    @DisplayName("Deve criar um usuário")
    public void saveNewUser() throws Exception {
        //Cenário
        User user = createNewUser();
        Mockito.when(userRepository.save(user)).thenReturn(savedUser());

        //Execução
        UserDTO resultSavedUser = userService.save(UserDTO.convert(user));

        //Verificação
        Assertions.assertThat(resultSavedUser.getNome()).isEqualTo("Mateus");

    }

    private User createNewUser() {
        User user = new User();
        user.setNome("Mateus");
        user.setCpf("000.000.000-00");
        user.setEmail("teste@email.com");
        user.setEndereco("Rua dos Devs");
        user.setTelefone("00 1111-2222");

        return user;
    }

    private User savedUser() {
        User user = new User();
        user.setId(1L);
        user.setNome("Mateus");
        user.setCpf("000.000.000-00");
        user.setEmail("teste@email.com");
        user.setEndereco("Rua dos Devs");
        user.setTelefone("00 1111-2222");

        return user;
    }
}
