package com.fatec.spring.boot.repository;

import com.fatec.spring.boot.model.Papel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Sham e Lucas
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class PapelRepositoryTest {

    private static final String descricao = "Papel Teste";

    @Autowired
    private PapelRepository papelRepository;

    public void setPapelRepository(PapelRepository papelRepository) {
        this.papelRepository = papelRepository;
    }

    @Test
    public void insercaoPapelTest() {
        Papel papel = new Papel();
        papel.setDescricao(descricao);
        papelRepository.save(papel);
        assertNotNull(papel.getId());
    }

    @Test
    public void buscaPapelTest() {
        Papel papel = new Papel();
        papel.setDescricao(descricao);
        papelRepository.save(papel);
        Papel expected = papelRepository.findById(papel.getId()).get();
        assertEquals(expected, papel);
    }

}
