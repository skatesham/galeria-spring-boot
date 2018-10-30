package com.fatec.spring.boot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fatec.spring.boot.model.Usuario;
import com.fatec.spring.boot.repository.Criptografia;
import com.fatec.spring.boot.security.JwtUtils;
import com.fatec.spring.boot.security.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RootController {

    @Autowired
    private AuthenticationManager auth;

    public void setAuth(AuthenticationManager auth) {
        this.auth = auth;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Usuario> login(@RequestBody Login login, HttpServletResponse response) throws JsonProcessingException {
        Authentication credentials = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
        Usuario usuario = (Usuario) auth.authenticate(credentials).getPrincipal();
        response.setHeader("Token", JwtUtils.generateToken(usuario));
        return new ResponseEntity<>(usuario, HttpStatus.OK);

    }

    @RequestMapping(value = "/")
    public String teste() {

        return "BEM VINDO A API GALERIA DE IMAGENS\n" +
                "Para o login acesse /login\n";

    }


}
