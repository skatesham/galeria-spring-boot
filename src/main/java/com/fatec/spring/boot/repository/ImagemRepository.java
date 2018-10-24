package com.fatec.spring.boot.repository;

import com.fatec.spring.boot.model.Imagem;
import com.fatec.spring.boot.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface ImagemRepository extends CrudRepository<Imagem, Long> {

    public Set<Imagem> findByUsuario(Usuario usuario);

    public Set<Imagem> findByUsuarioEmail(String email);
}
