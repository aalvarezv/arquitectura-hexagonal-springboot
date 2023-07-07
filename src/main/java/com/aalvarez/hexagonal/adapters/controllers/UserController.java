package com.aalvarez.hexagonal.adapters.controllers;

import com.aalvarez.hexagonal.adapters.controllers.dto.UserRequest;
import com.aalvarez.hexagonal.adapters.controllers.dto.UserResponse;
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

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(modelMapper.map(getUserUseCase.getUserById(id), UserResponse.class), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(getUserUseCase.getAllUsers()
                .stream().map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> saveUser(@Valid  @RequestBody UserRequest userRequest) {
        User user = saveUserUseCase.save(modelMapper.map(userRequest, User.class));
        return new ResponseEntity<>(modelMapper.map(user, UserResponse.class), HttpStatus.CREATED);
    }


}
