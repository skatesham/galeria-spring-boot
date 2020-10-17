package com.fatec.spring.boot.service;

import com.fatec.spring.boot.model.Papel;
import com.fatec.spring.boot.repository.PapelRepository;
import com.fatec.spring.boot.model.EnumPapel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service("papelService")
public class PapelServiceImpl implements PapelService {

    @Autowired
    PapelRepository papelRepo;

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
