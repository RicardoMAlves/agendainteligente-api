package com.neki.agendaInteligente.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neki.agendaInteligente.exception.RegraNegocioException;
import com.neki.agendaInteligente.model.entity.Chave;
import com.neki.agendaInteligente.model.repository.ChaveRepository;
import com.neki.agendaInteligente.service.ChaveService;

@Service
public class ChaveServiceImpl implements ChaveService {
	
	private ChaveRepository repository;
	
	@Autowired
	public ChaveServiceImpl(ChaveRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional
	public Chave salvar(Chave chave) {
		validar(chave);
		return repository.save(chave);
	}

	@Override
	@Transactional
	public Chave atualizar(Chave chave) {
		Objects.requireNonNull(chave.getChavCdId());
		validar(chave);
		return repository.save(chave);
	}

	@Override
	@Transactional
	public void deletar(Chave chave) {
		Objects.requireNonNull(chave.getChavCdId());
		repository.delete(chave);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Chave> buscar(Chave chaveFiltro) {
		Example example = Example.of( chaveFiltro,
				ExampleMatcher.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		
		return repository.findAll(example);
	}

	@Override
	public void validar(Chave chave) {
		
		if (chave.getChavTxNome() == null || chave.getChavTxNome().trim().equals("")) {
			throw new RegraNegocioException("Informe um nome válido.");
		}
		
		if (chave.getChavTxDescricao() == null || chave.getChavTxDescricao().trim().equals("")) {
			throw new RegraNegocioException("Informe uma descrição válida.");
		}
		
		if (chave.getChavTxSlug() == null || chave.getChavTxSlug().trim().equals("")) {
			throw new RegraNegocioException("Informe um NOME válido.");
		}
		
		if (chave.getChaveTipo() == null || chave.getChaveTipo().getChtpCdId() == null) {
			throw new RegraNegocioException("Inform um tipo de campo válido");
		}
		
	}

	@Override
	public Optional<Chave> obterPorId(Long id) {
		return repository.findById(id);
	}

}
