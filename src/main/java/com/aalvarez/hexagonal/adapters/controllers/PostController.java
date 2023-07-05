package com.aalvarez.hexagonal.adapters.controllers;

import com.aalvarez.hexagonal.adapters.controllers.dto.PostDTO;
import com.aalvarez.hexagonal.application.ports.in.SavePostUseCase;
import com.aalvarez.hexagonal.domain.model.Post;
import com.aalvarez.hexagonal.domain.model.User;
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
    public ResponseEntity<?> savePost(@Valid @RequestBody PostDTO postDTO) throws Exception {

        Post post = modelMapper.map(postDTO, Post.class);
        savePostUseCase.savePost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


}
