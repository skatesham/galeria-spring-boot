package com.fatec.spring.boot.service;

import java.util.Optional;
import java.util.Set;

import com.fatec.spring.boot.model.EnumPapel;
import com.fatec.spring.boot.model.Usuario;



public interface UsuarioService {

	public Usuario incluirUsuario(Usuario usuario);
	
	public Set<Usuario> lerTodos();
	
	public Usuario incluirUsuario(Usuario usuario, EnumPapel papel);

	public Optional<Usuario> lerUsuarioByNomeUsuario(String nomeUsuario);

	public Usuario atualizarUsuario(Usuario usuario);

}
