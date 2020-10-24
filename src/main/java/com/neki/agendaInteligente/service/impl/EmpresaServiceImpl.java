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
import com.neki.agendaInteligente.model.entity.Empresa;
import com.neki.agendaInteligente.model.repository.EmpresaRepository;
import com.neki.agendaInteligente.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	private EmpresaRepository repository;

	@Autowired
	public EmpresaServiceImpl(EmpresaRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional
	public Empresa salvar(Empresa empresa) {
		validar(empresa);
		return repository.save(empresa);
	}

	@Override
	@Transactional
	public Empresa atualizar(Empresa empresa) {
		Objects.requireNonNull(empresa.getEmpCdId());
		validar(empresa);
		return repository.save(empresa);
	}

	@Override
	@Transactional
	public void deletar(Empresa empresa) {
		Objects.requireNonNull(empresa.getEmpCdId());
		repository.delete(empresa);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empresa> buscar() {
		return repository.findAll();
	}

	@Override
	public void validar(Empresa empresa) {
		if (empresa.getEmpTxRazaoSocial() == null || empresa.getEmpTxRazaoSocial().trim().equals("")) {
			throw new RegraNegocioException("Informe uma razão social válida.");
		}
		
		if (empresa.getEmpTxNomeFantasia() == null || empresa.getEmpTxNomeFantasia().trim().equals("")) {
			throw new RegraNegocioException("Informe um nome fantasia válido.");
		}
		
		if (empresa.getEmpTxToken() == null || empresa.getEmpTxToken().trim().equals("")) {
			throw new RegraNegocioException("Informe um TOKEN válido.");
		}
		
		if (empresa.getEmpCdTipoEmpresa() < 1) {
			throw new RegraNegocioException("Inform um tipo de empresa válido");
		}
	}

	@Override
	public Optional<Empresa> obterPorId(Long id) {
		return repository.findById(id);
	}

}
