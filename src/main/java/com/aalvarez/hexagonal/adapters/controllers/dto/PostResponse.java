package com.aalvarez.hexagonal.adapters.controllers.dto;

import lombok.Data;

@Data
public class PostResponse {

    private Long id;
    private String comment;
    private UserResponse user;

}
