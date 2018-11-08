package com.fatec.spring.boot.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.spring.boot.model.Usuario;
import com.fatec.spring.boot.service.UsuarioService;
import com.fatec.spring.boot.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Set;

// @CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @JsonView(View.UsuarioFull.class)
    @Transactional
    public ResponseEntity<Collection<Usuario>> getAll(HttpServletRequest request, HttpServletResponse response) {

        Set<Usuario> usuarios = usuarioService.lerTodos();
        return new ResponseEntity<Collection<Usuario>>(usuarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{nome}", method = RequestMethod.GET)
    @JsonView(View.UsuarioSimples.class)
    @Transactional
    public ResponseEntity<Usuario> getUsuarioByUserName(@PathVariable("nome") String nome) {

        Usuario usuario = usuarioService.lerUsuarioByNomeUsuario(nome).get();

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @RequestMapping(value = "/getFull/{nome}", method = RequestMethod.GET)
    @JsonView(View.UsuarioFull.class)
    @Transactional
    public ResponseEntity<Usuario> getUsuarioByUserNameCompleto(@PathVariable("nome") String nome) {

        Usuario usuario = usuarioService.lerUsuarioByNomeUsuario(nome).get();

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @JsonView(View.UsuarioFull.class)
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario, HttpServletRequest request, HttpServletResponse response) {
        try {
            usuario = usuarioService.incluirUsuario(usuario);
            response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/usuario/getById?id=" + usuario.getId());
            return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Usuario>(usuario, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
