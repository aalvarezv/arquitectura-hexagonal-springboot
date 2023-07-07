package com.aalvarez.hexagonal.adapters.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import com.aalvarez.hexagonal.adapters.exceptions.custom.TemplateException;
import com.aalvarez.hexagonal.adapters.exceptions.custom.NotFoundException;
import com.aalvarez.hexagonal.adapters.exceptions.dto.ExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerConfig {

    /**
     * Manejo de error con clase Existente en este caso RuntimeException
     * @param RuntimeException ex
     * @return ResponseEntity<ErrorDTO>
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ExceptionDTO> runTimeExceptionHandler(RuntimeException ex){
        ExceptionDTO error = ExceptionDTO.builder().code(String.valueOf(ex.hashCode())).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Manejo de error custom, en este caso NotFoundException
     * @param NotFoundException
     * @return ResponseEntity<ErrorDTO>
     */
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionDTO> notFoundExceptionHandler(NotFoundException ex){
        ExceptionDTO error = ExceptionDTO.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .comment(ex.getComment())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Manejo de error custom, en este caso TemplateException.
     * Este recibe el HttpStatus cuando se dispara el error, así puede enviar
     * cualquier código de error http
     * @param ex
     * @return ResponseEntity<ErrorDTO>
     */
    @ExceptionHandler(value = TemplateException.class)
    public ResponseEntity<ExceptionDTO> templateExceptionHandler(TemplateException ex){
        ExceptionDTO error = ExceptionDTO.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .comment(ex.getComment())
                .build();
        return new ResponseEntity<>(error,ex.getHttpStatus());
    }


    /**
     * Manejo de errores capturados por la anotación @Valid.
     * @param ex
     * @return ResponseEntity<?>
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    //<Map<String, List<String>>>
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("errors", errors.stream()
                .map(error -> Map.of("campo", error.getField(), "mensaje", error.getDefaultMessage()))
                .collect(Collectors.toList()));

        return new ResponseEntity<>(resultMap, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


}
