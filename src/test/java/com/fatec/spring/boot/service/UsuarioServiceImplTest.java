package com.fatec.spring.boot.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.spring.boot.model.EnumPapel;
import com.fatec.spring.boot.model.Usuario;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UsuarioServiceImplTest {

    private static final String nome = "Usuario X";
    private static final String email = "user@user.com";
    private static final String user = "user";
    private static final String senha = "123";

    @Autowired
    UsuarioService usuarioService;

    @Test
    public void incluirUsuarioTest() {
        Usuario expected = new Usuario();
        expected.setNome(nome);
        expected.setEmail(email);
        expected.setSenha(senha);
        expected.setUsuario(user);
        EnumPapel papel = EnumPapel.ADMINISTRADOR;
        Usuario actual = usuarioService.incluirUsuario(expected, papel);
        assertNotNull(actual.getId());

    }

    @Test
    public void buscarByUsuarioTest() {
        Usuario expected = new Usuario();
        expected.setNome(nome);
        expected.setEmail(email);
        expected.setSenha(senha);
        expected.setUsuario(user);
        EnumPapel papel = EnumPapel.ADMINISTRADOR;
        expected = usuarioService.incluirUsuario(expected, papel);
        Usuario actual = usuarioService.lerUsuarioByNomeUsuario(user).get();
        assertEquals(expected, actual);
    }

    @Test
    public void atualizarUsuarioTest() {
        fail("Método não desenvolvido ainda");
    }
}
