package com.aalvarez.hexagonal.adapters.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
@Data
public class UserDTO {

    @NotNull(message = "no puede ser vacío.")
    @Range(min=1, max=100, message = "debe ser entre 1 y 100.")
    private Long id;
    @NotBlank(message = "no puede ser vacío.")
    private String name;
    private Long password;


}
