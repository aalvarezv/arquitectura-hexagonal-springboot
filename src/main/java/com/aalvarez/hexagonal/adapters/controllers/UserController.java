package com.aalvarez.hexagonal.adapters.controllers;

import com.aalvarez.hexagonal.adapters.controllers.dto.UserDTO;
import com.aalvarez.hexagonal.application.ports.in.GetUserUseCase;
import com.aalvarez.hexagonal.application.ports.in.SaveUserUseCase;
import com.aalvarez.hexagonal.domain.model.User;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private GetUserUseCase getUserUseCase;

    @Autowired
    private SaveUserUseCase saveUserUseCase;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(getUserUseCase.getUserById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(getUserUseCase.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> saveUser(@Valid  @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(saveUserUseCase.save(modelMapper.map(userDTO, User.class)), HttpStatus.OK);
    }


}
