package com.luccasaps.apptreino.service;

import com.luccasaps.apptreino.model.Exercicio;
import com.luccasaps.apptreino.model.User;
import com.luccasaps.apptreino.model.dto.UserDTO;
import com.luccasaps.apptreino.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public User patch(UUID id, UserDTO dto){
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if(dto.email() != null){
            user.setEmail(dto.email());
        }
        if(dto.senha() != null){
            user.setSenha(dto.senha());
        }
        return repository.save(user);
    }

}
