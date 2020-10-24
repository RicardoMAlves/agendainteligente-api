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
import com.neki.agendaInteligente.model.entity.ChaveTipo;
import com.neki.agendaInteligente.model.repository.ChaveTipoRepository;
import com.neki.agendaInteligente.service.ChaveTipoService;

@Service
public class ChaveTipoServiceImpl implements ChaveTipoService {
	
	private ChaveTipoRepository repository;
	
	@Autowired
	public ChaveTipoServiceImpl(ChaveTipoRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional
	public ChaveTipo salvar(ChaveTipo chaveTipo) {
		validar(chaveTipo);
		return repository.save(chaveTipo);
	}

	@Override
	@Transactional
	public ChaveTipo atualizar(ChaveTipo chaveTipo) {
		Objects.requireNonNull(chaveTipo.getChtpCdId());
		validar(chaveTipo);
		return repository.save(chaveTipo);
	}

	@Override
	@Transactional
	public void deletar(ChaveTipo chaveTipo) {
		Objects.requireNonNull(chaveTipo.getChtpCdId());
		repository.delete(chaveTipo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ChaveTipo> buscar(ChaveTipo chaveTipoFiltro) {
		Example example = Example.of( chaveTipoFiltro,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return repository.findAll(example);
	}

	@Override
	public void validar(ChaveTipo chaveTipo) {

		if (chaveTipo.getChtpTxNome() == null || chaveTipo.getChtpTxNome().trim().equals("")) {
			throw new RegraNegocioException("Informe um nome válido.");
		}
		
	}

	@Override
	public Optional<ChaveTipo> obterPorId(Long id) {
		return repository.findById(id);
	}

}
