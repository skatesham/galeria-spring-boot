package com.fatec.spring.boot;

import com.fatec.spring.boot.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GaleriaImagensApplication {

    @Autowired
    UsuarioService service;

    public static void main(String[] args) {

        SpringApplication.run(GaleriaImagensApplication.class, args);
        System.out.println("Galeria de Imagens Ativa");


    }
}
