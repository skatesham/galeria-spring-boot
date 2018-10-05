package com.fatec.spring.boot.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.fatec.spring.boot.model.Imagem;
import com.fatec.spring.boot.model.Usuario;


public interface ImagemRepository extends CrudRepository<Imagem, Long> {

    public Set<Imagem> findByUsuario(Usuario usuario);

    public Set<Imagem> findByUsuarioEmail(String email);
}
