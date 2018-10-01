package com.fatec.spring.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.spring.boot.model.EnumPapel;
import com.fatec.spring.boot.model.Papel;
import com.fatec.spring.boot.model.Usuario;
import com.fatec.spring.boot.repository.UsuarioRepository;


@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PapelService papelService;

	@Override
	@Transactional
	public Usuario incluirUsuario(Usuario usuario, EnumPapel papel) {

		Optional<Papel> p = papelService.lerPapelByDescricao(papel);

		if (p.isPresent()) {
			usuario.setPapel(p.get());
		}
		return usuarioRepository.save(usuario);
		
	}

	@Override
	@Transactional
	public Optional<Usuario> lerUsuarioByNomeUsuario(String nomeUsuario) {
		return usuarioRepository.findByUsuario(nomeUsuario);
	}

	@Override
	@Transactional
	public Usuario atualizarUsuario(Usuario usuario) {
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}

}
