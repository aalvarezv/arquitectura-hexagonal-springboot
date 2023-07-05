package com.aalvarez.hexagonal.adapters.controllers.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostDTO {

    private Long id;
    @NotBlank(message = "comment cannot be empty.")
    private String comment;
    private Long id_user;

}
