package com.fatec.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GaleriaImagensApplication {

    public static void main(String[] args) {

        SpringApplication.run(GaleriaImagensApplication.class, args);
        System.out.println("Galeria de Imagens Ativa");
    }
}
