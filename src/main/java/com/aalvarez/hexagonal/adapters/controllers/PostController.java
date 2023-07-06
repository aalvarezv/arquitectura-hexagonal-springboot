package com.aalvarez.hexagonal.adapters.controllers;

import com.aalvarez.hexagonal.adapters.controllers.dto.PostDTO;
import com.aalvarez.hexagonal.application.ports.in.SavePostUseCase;
import com.aalvarez.hexagonal.domain.model.Post;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private SavePostUseCase savePostUseCase;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("test posts", HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> savePost(@Valid @RequestBody PostDTO postDTO){
        return new ResponseEntity<>(savePostUseCase.save(modelMapper.map(postDTO, Post.class)), HttpStatus.CREATED);
    }


}
