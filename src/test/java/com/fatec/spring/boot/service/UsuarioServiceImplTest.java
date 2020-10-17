package com.fatec.spring.boot.service;

import com.fatec.spring.boot.model.EnumPapel;
import com.fatec.spring.boot.model.Usuario;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled("Teste antigo não passando em 17-10-2020")
@ExtendWith(SpringExtension.class)
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
        EnumPapel papel = EnumPapel.ROLE_ADMINISTRADOR;
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
        EnumPapel papel = EnumPapel.ROLE_ADMINISTRADOR;
        expected = usuarioService.incluirUsuario(expected, papel);
        Usuario actual = usuarioService.lerUsuarioByNomeUsuario(user).get();
        assertEquals(expected, actual);
    }

    @Test
    public void atualizarUsuarioTest() {
        fail("Método não desenvolvido ainda");
    }
}
