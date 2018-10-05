package com.fatec.spring.boot.service;

import java.util.Optional;
import java.util.Set;

import com.fatec.spring.boot.model.Imagem;
import com.fatec.spring.boot.model.Usuario;


public interface ImagemService {

    public Imagem incluirImage(Imagem img);

    public Optional<Imagem> lerImagemById(long id);

    public Set<Imagem> lerImagensByUsuario(Usuario usuario);

    public Set<Imagem> lerImagensByUsuarioEmail(String email);

}
