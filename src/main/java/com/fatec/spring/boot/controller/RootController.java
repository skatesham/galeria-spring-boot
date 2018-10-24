package com.fatec.spring.boot.controller;

import java.util.Collection;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.spring.boot.model.Usuario;
import com.fatec.spring.boot.service.UsuarioService;
import com.fatec.spring.boot.view.View;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class RootController {

    @RequestMapping(value = "/")
    public String teste() {

        return "BEM VINDO A API GALERIA DE IMAGENS";
    }

    @RequestMapping(value = "/error")
    public String error() {

        return "ERRO FATAL! Problema ao iniciar A API GALERIA DE IMAGENS";
    }

}
