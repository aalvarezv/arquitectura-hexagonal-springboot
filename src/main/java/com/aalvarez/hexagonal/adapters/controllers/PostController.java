package com.aalvarez.hexagonal.adapters.controllers;

import com.aalvarez.hexagonal.adapters.controllers.dto.PostRequest;
import com.aalvarez.hexagonal.adapters.controllers.dto.PostResponse;
import com.aalvarez.hexagonal.application.ports.in.GetPostUseCase;
import com.aalvarez.hexagonal.application.ports.in.SavePostUseCase;
import com.aalvarez.hexagonal.domain.model.Post;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private SavePostUseCase savePostUseCase;
    @Autowired
    private GetPostUseCase getPostUseCase;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<?> getAllPost() {
        return new ResponseEntity<>(getPostUseCase.getAllPost()
                .stream().map(post -> modelMapper.map(post, PostResponse.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> savePost(@Valid @RequestBody PostRequest postRequest){
        Post post = savePostUseCase.save(modelMapper.map(postRequest, Post.class));
        return new ResponseEntity<>(modelMapper.map(post, PostResponse.class), HttpStatus.CREATED);
    }

}
