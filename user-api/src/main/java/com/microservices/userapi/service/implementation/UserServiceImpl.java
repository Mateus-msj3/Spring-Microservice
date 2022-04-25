package com.microservices.userapi.service.implementation;

import com.microservices.userapi.model.User;
import com.microservices.userapi.model.dto.UserDTO;
import com.microservices.userapi.repository.UserRepository;
import com.microservices.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::convert).collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return UserDTO.convert(user.get());
        }
        return null;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));
        return UserDTO.convert(user);
    }

    @Override
    public UserDTO delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
           userRepository.delete(user.get());
        }
        return null;
    }

    @Override
    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if (user != null) {
            return UserDTO.convert(user);
        }
        return null;
    }

    @Override
    public List<UserDTO> queryByName(String nome) {
        List<User> users = userRepository.queryByNomeLike(nome);
        return users.stream().map(UserDTO::convert).collect(Collectors.toList());
    }
}
