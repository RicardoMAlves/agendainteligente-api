package com.neki.agendaInteligente.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dentista {

	private Long id;
	private Long idpessoa;
	private String nome;
	private boolean ativo;
	private String tipoExecutor;

}
