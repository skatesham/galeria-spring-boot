package com.fatec.spring.boot.service;

import com.fatec.spring.boot.model.Papel;
import com.fatec.spring.boot.model.EnumPapel;

import java.util.Optional;


public interface PapelService {

    public Papel incluirPapel(Papel papel);

    public Optional<Papel> lerPapelById(long id);

    public Optional<Papel> lerPapelByDescricao(EnumPapel enumPapel);

}
