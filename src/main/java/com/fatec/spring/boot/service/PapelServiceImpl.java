package com.fatec.spring.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.spring.boot.model.EnumPapel;
import com.fatec.spring.boot.model.Papel;


@Service("papelService")
public class PapelServiceImpl implements PapelService {

    @Autowired
    com.fatec.spring.boot.repository.PapelRepository papelRepo;

    @Override
    @Transactional
    public Papel incluirPapel(Papel papel) {
        return papelRepo.save(papel);
    }

    @Override
    @Transactional
    public Optional<Papel> lerPapelById(long id) {
        return papelRepo.findById(id);
    }

    @Override
    @Transactional
    public Optional<Papel> lerPapelByDescricao(EnumPapel enumPapel) {
        return papelRepo.findByDescricao(enumPapel.getDescricao());
    }


}
