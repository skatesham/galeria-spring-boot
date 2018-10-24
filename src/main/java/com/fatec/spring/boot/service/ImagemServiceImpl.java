package com.fatec.spring.boot.service;

import com.fatec.spring.boot.model.Imagem;
import com.fatec.spring.boot.model.Usuario;
import com.fatec.spring.boot.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;


@Service("imagemService")
public class ImagemServiceImpl implements ImagemService {

    @Autowired
    ImagemRepository imagemRepo;

    @Override
    @Transactional
    public Imagem incluirImage(Imagem img) {
        return imagemRepo.save(img);
    }

    @Override
    @Transactional
    public Optional<Imagem> lerImagemById(long id) {
        return imagemRepo.findById(id);
    }

    @Override
    @Transactional
    public Set<Imagem> lerImagensByUsuario(Usuario usuario) {
        return imagemRepo.findByUsuario(usuario);
    }

    @Override
    public Set<Imagem> lerImagensByUsuarioEmail(String email) {
        return imagemRepo.findByUsuarioEmail(email);

    }


}
