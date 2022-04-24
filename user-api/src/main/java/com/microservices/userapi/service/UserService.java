package com.microservices.userapi.service;

import com.microservices.userapi.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAll();

    UserDTO findById(Long id);

    UserDTO save(UserDTO userDTO);

    UserDTO delete(Long id);

    UserDTO findByCpf(String cpf);

    List<UserDTO> queryByName(String name);

}
