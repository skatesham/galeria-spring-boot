package com.fatec.spring.boot.service;

import com.fatec.spring.boot.model.Imagem;
import com.fatec.spring.boot.model.Usuario;

import java.util.Optional;
import java.util.Set;


public interface ImagemService {

    public Imagem incluirImage(Imagem img);

    public Optional<Imagem> lerImagemById(long id);

    public Set<Imagem> lerImagensByUsuario(Usuario usuario);

    public Set<Imagem> lerImagensByUsuarioEmail(String email);

}
