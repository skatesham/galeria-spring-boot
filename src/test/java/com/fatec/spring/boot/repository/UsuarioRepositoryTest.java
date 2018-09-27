package com.fatec.spring.boot.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.spring.boot.model.EnumPapel;
import com.fatec.spring.boot.model.Papel;
import com.fatec.spring.boot.model.Usuario;


/**
 * @author Sham e Lucas
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UsuarioRepositoryTest {
	
	private static final String nome = "Usuario X";
	private static final String email = "user@user.com";
	private static final String user = "user";
	private static final String senha = "123";
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public void setPapelRepository(PapelRepository papelRepository) {
		this.papelRepository = papelRepository;
	}



	@Test
	public void insercaoUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);;
		usuario.setSenha(senha);
		usuario.setUsuario(user);
		Papel papel = new Papel(EnumPapel.TESTE);
		papel = papelRepository.save(papel);
		usuario.setPapel(papel);
		usuarioRepository.save(usuario);
		assertNotNull(usuario.getId());
		
	}
	
	@Test
	public void buscaUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);;
		usuario.setSenha(senha);
		usuario.setUsuario(user);
		
		Papel papel = new Papel(EnumPapel.TESTE);
		papel = papelRepository.save(papel);
		usuario.setPapel(papel);
		usuarioRepository.save(usuario);
		
		Usuario expected = usuarioRepository.findById(usuario.getId()).get();
		assertEquals(expected, usuario);
	}
	

	@Test
	public void BuscaPorEmailTest() {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);;
		usuario.setSenha(senha);
		usuario.setUsuario(user);
		Papel papel = new Papel(EnumPapel.TESTE);
		papel = papelRepository.save(papel);
		usuario.setPapel(papel);
		usuarioRepository.save(usuario);
		
		Usuario actual = usuarioRepository.buscarUsuarioPorEmail(email).get();
		
		assertEquals(usuario, actual);
		
	}
	
	@Test
	public void exclusaoUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);;
		usuario.setSenha(senha);
		usuario.setUsuario(user);
		Papel papel = new Papel(EnumPapel.TESTE);
		papel = papelRepository.save(papel);
		usuario.setPapel(papel);
		usuarioRepository.save(usuario);
		usuarioRepository.delete(usuario);
		
		assertFalse(usuarioRepository.buscarUsuarioPorEmail(email).isPresent());
		
		
		
	}
	
	
}
