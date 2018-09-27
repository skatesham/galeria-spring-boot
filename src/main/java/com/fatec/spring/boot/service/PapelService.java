package com.fatec.spring.boot.service;

import java.util.Optional;

import com.fatec.spring.boot.model.EnumPapel;
import com.fatec.spring.boot.model.Papel;



public interface PapelService {
	
	public Papel incluirPapel(Papel papel);

	public Optional<Papel> lerPapelById(long id);
	
	public Optional<Papel> lerPapelByDescricao(EnumPapel enumPapel);
	
}
