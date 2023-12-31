package com.aalvarez.hexagonal.adapters.exceptions.custom;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class TemplateException extends RuntimeException{

        private String code;
        private String comment;
        private HttpStatus httpStatus;

        public TemplateException(String code, String message, String comment, HttpStatus httpStatus){
            super(message);
            this.code = code;
            this.comment = comment;
            this.httpStatus = httpStatus;
        }

}
