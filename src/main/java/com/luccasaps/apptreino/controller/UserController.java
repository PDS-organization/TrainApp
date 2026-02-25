package com.luccasaps.apptreino.controller;

import com.luccasaps.apptreino.model.User;
import com.luccasaps.apptreino.model.dto.UserDTO;
import com.luccasaps.apptreino.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = service.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getById(@PathVariable UUID id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        user = service.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<User> patch(@PathVariable UUID id, @RequestBody UserDTO dto){
        return ResponseEntity.ok(service.patch(id, dto));
    }

}
