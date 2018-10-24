package com.fatec.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class RootController {

    @RequestMapping(value = "/")
    public String teste() {

        return "BEM VINDO A API GALERIA DE IMAGENS";
    }


}
