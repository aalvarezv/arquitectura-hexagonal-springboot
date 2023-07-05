package com.aalvarez.hexagonal.adapters.exceptions.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionDTO {

    private String code;
    private String message;
    private String comment;

}
