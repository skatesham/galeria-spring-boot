package com.fatec.spring.boot.repository;

import com.fatec.spring.boot.model.Papel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface PapelRepository extends CrudRepository<Papel, Long> {

    public Optional<Papel> findByDescricao(String descricao);

}
