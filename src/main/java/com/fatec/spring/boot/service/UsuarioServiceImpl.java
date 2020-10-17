package com.fatec.spring.boot.service;

import com.fatec.spring.boot.model.EnumPapel;
import com.fatec.spring.boot.model.Papel;
import com.fatec.spring.boot.model.Usuario;
import com.fatec.spring.boot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PapelService papelService;

    @Override
    @Transactional
    public Usuario incluirUsuario(Usuario usuario) {
        usuario.setPapel(papelService.incluirPapel(usuario.getPapel()));
        usuario.setSenha(md5(usuario.getSenha()));
        return usuarioRepository.save(usuario);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    @Transactional
    public Set<Usuario> lerTodos() {
        Set<Usuario> set = new HashSet<>((Collection<Usuario>) usuarioRepository.findAll());
        return set;
    }

    @PreAuthorize("isAuthenticated()")
    @Override
    @Transactional
    public Usuario incluirUsuario(Usuario usuario, EnumPapel papel) {

        Optional<Papel> p = papelService.lerPapelByDescricao(papel);

        if (p.isPresent()) {
            usuario.setPapel(p.get());
        }
        usuario.setSenha(md5(usuario.getSenha()));
        return usuarioRepository.save(usuario);

    }

    @PreAuthorize("isAuthenticated()")
    @Override
    @Transactional
    public Optional<Usuario> lerUsuarioByNomeUsuario(String nomeUsuario) {
        return usuarioRepository.findByUsuario(nomeUsuario);
    }

    @PreAuthorize("isAuthenticated()")
    @Override
    @Transactional
    public Usuario atualizarUsuario(Usuario usuario) {
        usuario = usuarioRepository.save(usuario);
        return usuario;
    }

    private String md5(String senha) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            hexString.append("{MD5}");
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", 0xFF & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
            // Unexpected - do nothing
        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
            // Unexpected - do nothing
        }
        return senha;
    }

}
