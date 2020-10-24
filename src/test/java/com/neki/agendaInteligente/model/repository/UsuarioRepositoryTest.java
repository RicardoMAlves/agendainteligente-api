package com.neki.agendaInteligente.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.neki.agendaInteligente.model.entity.Usuario;

@SpringBootTest
@ExtendWith( SpringExtension.class )
public class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		//Cenário
		Usuario usuario = Usuario.builder().usuTxNome("usuario").usuTxEmail("usuario@email.com").usuTxSenha("122").build();
		repository.save(usuario);
		
		//Acao e Execucao
		boolean result = repository.existsByusuTxEmail("usuario@email.com");
		
		//Verificacao
		Assertions.assertThat(result).isTrue();
		
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail( ) {
		//Cenário
		repository.deleteAll();
		
		//Acao
		boolean result = repository.existsByusuTxEmail("usuario@email.com");
		
		//Verificacao
		Assertions.assertThat(result).isFalse();
		
	}

}
