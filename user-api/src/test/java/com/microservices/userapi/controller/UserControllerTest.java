package com.microservices.userapi.controller;

import com.microservices.userapi.model.User;
import com.microservices.userapi.model.dto.UserDTO;
import com.microservices.userapi.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.containsString;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {UserController.class})
@AutoConfigureMockMvc
public class UserControllerTest {

    static String USER_API = "/users";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    @DisplayName("Deve criar um novo usuário")
    void findAllUsers() throws Exception {
        User user = new User(1l, "Mateus", "000.000.000-00", "Rua A", "teste@email.com", "00 1111-2222");
        List<User> list = List.of(user);
        Mockito.when(userService.getAll()).thenReturn(list.stream().map(UserDTO::convert).collect(Collectors.toList()));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("000.000.000-00")));
    }
}
