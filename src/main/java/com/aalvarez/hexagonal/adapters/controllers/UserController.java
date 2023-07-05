package com.aalvarez.hexagonal.adapters.controllers;

import com.aalvarez.hexagonal.application.ports.in.GetUserUseCase;
import com.aalvarez.hexagonal.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private GetUserUseCase getUserUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        return new ResponseEntity<>(getUserUseCase.getUserById(id), HttpStatus.OK);
    }


}
