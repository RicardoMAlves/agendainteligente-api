package com.neki.agendaInteligente.service;

import java.util.List;
import java.util.Optional;

import com.neki.agendaInteligente.model.entity.Empresa;

public interface EmpresaService {
	
	Empresa salvar(Empresa empresa);
	
	Empresa atualizar(Empresa empresa);
	
	void deletar(Empresa empresa);
	
	List<Empresa> buscar();
	
	void validar(Empresa empresa);
	
	Optional<Empresa> obterPorId(Long id);
	
}
