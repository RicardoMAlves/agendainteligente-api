package com.neki.agendaInteligente.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.neki.agendaInteligente.model.entity.Usuario;
import com.neki.agendaInteligente.model.repository.UsuarioRepository;

@SpringBootTest
@ExtendWith( SpringExtension.class )
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveValidarEmail() {
		//Cenario
		repository.deleteAll();
		
		//Acao
		service.validarEmail("sfsfsfsf@email.com");
	}
	
	@Test
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		//Cenário
		Usuario usuario = Usuario.builder().usuTxNome("usuarioxxx").usuTxEmail("usuarioxxx@email.com").usuTxSenha("122").build();
		repository.save(usuario);
		
		//Acao
		//service.validarEmail("usuarioxxx@email.com");
	}

}
