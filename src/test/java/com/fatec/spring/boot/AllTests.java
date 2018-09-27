package com.fatec.spring.boot;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fatec.spring.boot.repository.ImagemRepositoryTest;
import com.fatec.spring.boot.repository.PapelRepositoryTest;
import com.fatec.spring.boot.repository.UsuarioRepositoryTest;
import com.fatec.spring.boot.service.ImagemServiceImplTest;
import com.fatec.spring.boot.service.PapelServiceImplTest;
import com.fatec.spring.boot.service.UsuarioServiceImplTest;


@RunWith(Suite.class)
@SuiteClasses({ 
	
	PapelRepositoryTest.class,
	PapelServiceImplTest.class,
	UsuarioRepositoryTest.class,
	UsuarioServiceImplTest.class,
	ImagemRepositoryTest.class,
	ImagemServiceImplTest.class
	
	
})
public class AllTests {

}
