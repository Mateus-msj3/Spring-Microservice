package com.microservices.userapi.controller;

import com.microservices.userapi.model.dto.UserDTO;
import com.microservices.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping()
    public List<UserDTO> getUsers() {
        List<UserDTO> userDTOS = userService.getAll();
        return userDTOS;
    }

    @GetMapping("/{id}")
    UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/cpf/{cpf}")
    UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @GetMapping("/search")
    public List<UserDTO> queryByName(@RequestParam(name="nome", required = true) String nome) {
        return userService.queryByName(nome);
    }

    @DeleteMapping("/{id}")
    UserDTO delete(@PathVariable Long id) {
        return userService.delete(id);
    }

}
