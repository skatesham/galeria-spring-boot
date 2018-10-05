package com.fatec.spring.boot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fatec.spring.boot.model.Papel;


public interface PapelRepository extends CrudRepository<Papel, Long> {

    public Optional<Papel> findByDescricao(String descricao);

}
