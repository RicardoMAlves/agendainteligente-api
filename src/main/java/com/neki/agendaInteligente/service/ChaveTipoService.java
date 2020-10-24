package com.neki.agendaInteligente.service;

import java.util.List;
import java.util.Optional;

import com.neki.agendaInteligente.model.entity.ChaveTipo;

public interface ChaveTipoService {
	
	ChaveTipo salvar(ChaveTipo chaveTipo);
	
	ChaveTipo atualizar(ChaveTipo chaveTipo);
	
	void deletar(ChaveTipo chaveTipo);
	
	List<ChaveTipo> buscar(ChaveTipo chaveTipoFiltro);
	
	void validar(ChaveTipo chaveTipo);
	
	Optional<ChaveTipo> obterPorId(Long id);

}
