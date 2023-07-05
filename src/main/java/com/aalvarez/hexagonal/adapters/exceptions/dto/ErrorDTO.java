package com.aalvarez.hexagonal.adapters.exceptions.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorDTO {
    List<String> errors;
}
