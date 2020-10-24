package com.neki.agendaInteligente.service;

import java.util.List;
import java.util.Optional;

import com.neki.agendaInteligente.model.entity.Chave;

public interface ChaveService {
	
	Chave salvar(Chave chave);
	
	Chave atualizar(Chave chave);
	
	void deletar(Chave chave);
	
	List<Chave> buscar(Chave chaveFiltro);
	
	void validar(Chave chave);
	
	Optional<Chave> obterPorId(Long id);

}
