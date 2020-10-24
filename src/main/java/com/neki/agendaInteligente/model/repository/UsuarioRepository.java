package com.neki.agendaInteligente.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.agendaInteligente.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	boolean existsByusuTxEmail(String email);
	
	Optional<Usuario> findByusuTxEmail(String email);

}
