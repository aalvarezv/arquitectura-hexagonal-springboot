package com.aalvarez.hexagonal.adapters.controllers.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostRequest {

    @NotBlank(message = "no puede ser vacío.")
    private String comment;
    private Long id_user;

}
