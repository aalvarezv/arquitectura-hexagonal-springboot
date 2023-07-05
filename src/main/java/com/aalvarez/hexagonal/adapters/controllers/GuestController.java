package com.aalvarez.hexagonal.adapters.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @GetMapping()
    public ResponseEntity<?> welcomeGuest() {
        return new ResponseEntity<>("Ruta sin seguridad", HttpStatus.OK);
    }


}
