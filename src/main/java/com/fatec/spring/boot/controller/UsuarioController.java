package com.fatec.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.spring.boot.model.Usuario;
import com.fatec.spring.boot.service.UsuarioService;
import com.fatec.spring.boot.view.View;

@RestController
@RequestMapping("/")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/")
	public String teste() {
		
		return "BEM VINDO A API GALERIA DE IMAGENS";	
	}
	
	@RequestMapping(value = "/usuario/get/{nome}", method = RequestMethod.GET)
	@JsonView(View.UsuarioSimples.class)
	@Transactional
	public ResponseEntity<Usuario> getUsuarioByUserName(@PathVariable ("nome") String nome) {
		
		Usuario usuario = usuarioService.lerUsuarioByNomeUsuario(nome).get();
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuario/getFull/{nome}", method = RequestMethod.GET)
	@JsonView(View.UsuarioFull.class)
	@Transactional
	public ResponseEntity<Usuario> getUsuarioByUserNameCompleto(@PathVariable ("nome") String nome) {
		
		Usuario usuario = usuarioService.lerUsuarioByNomeUsuario(nome).get();
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
}
