package com.fatec.spring.boot.service;

import com.fatec.spring.boot.model.EnumPapel;
import com.fatec.spring.boot.model.Papel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class PapelServiceImplTest {

    @Autowired
    PapelService papelService;

    @Test
    public void incluirPapelTest() {
        Papel expected = new Papel(EnumPapel.TESTE);
        Papel actual = papelService.incluirPapel(expected);
        assertNotNull(actual);
        assertEquals(expected, actual);

    }

    @Test
    public void lerPapelByIdTest() {
        Papel expected = new Papel(EnumPapel.TESTE);
        expected = papelService.incluirPapel(expected);
        Papel actual = papelService.lerPapelById(expected.getId()).get();
        assertNotNull(actual);
        assertEquals(expected, actual);

    }

    @Test
    public void lerPapelByDescricaoTest() {
        Papel expected = new Papel(EnumPapel.TESTE);
        expected = papelService.incluirPapel(expected);
        Papel actual = papelService.lerPapelByDescricao(EnumPapel.TESTE).get();
        assertEquals(expected, actual);
        assertNotNull(actual);
    }

}
