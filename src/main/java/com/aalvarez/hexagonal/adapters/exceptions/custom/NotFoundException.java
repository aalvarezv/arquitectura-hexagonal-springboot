package com.aalvarez.hexagonal.adapters.exceptions.custom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException{

        private String code;
        private String comment;

        public NotFoundException(String code, String message, String comment){
            super(message);
            this.code = code;
            this.comment = comment;
        }

}
