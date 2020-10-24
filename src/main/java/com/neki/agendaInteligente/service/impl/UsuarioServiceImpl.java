package com.neki.agendaInteligente.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neki.agendaInteligente.exception.ErroAutenticacao;
import com.neki.agendaInteligente.exception.RegraNegocioException;
import com.neki.agendaInteligente.model.entity.Usuario;
import com.neki.agendaInteligente.model.repository.UsuarioRepository;
import com.neki.agendaInteligente.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository repository;

	@Autowired
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		Optional<Usuario> usuario = repository.findByusuTxEmail(email);
		if (!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuário não encontrado.");
		}
		if (!usuario.get().getUsuTxSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha inválida.");
		}
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getUsuTxEmail());
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByusuTxEmail(email);
		if (existe) {
			throw new RegraNegocioException("Já existe usuário cadastrado com este email.");
		}
	}

}
