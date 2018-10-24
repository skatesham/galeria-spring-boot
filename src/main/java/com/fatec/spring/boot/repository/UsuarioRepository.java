package com.fatec.spring.boot.repository;

import com.fatec.spring.boot.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    public Optional<Usuario> findByUsuario(String usuario);

    @Query("select u from Usuario u where u.email = ?1 ")
    public Optional<Usuario> buscarUsuarioPorEmail(String email);

}
