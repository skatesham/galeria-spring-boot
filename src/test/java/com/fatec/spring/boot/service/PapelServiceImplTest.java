package com.fatec.spring.boot.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.spring.boot.model.EnumPapel;
import com.fatec.spring.boot.model.Papel;


@RunWith(SpringRunner.class)
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
