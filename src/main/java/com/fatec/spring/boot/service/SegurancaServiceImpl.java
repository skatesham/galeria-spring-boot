package com.fatec.spring.boot.service;

import com.fatec.spring.boot.model.Usuario;
import com.fatec.spring.boot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("segurancaService")
public class SegurancaServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByUsuario(nomeUsuario);
        if (!usuario.isPresent()) {
            throw new UsernameNotFoundException(nomeUsuario);
        }
        return usuario.get();

    }
}
