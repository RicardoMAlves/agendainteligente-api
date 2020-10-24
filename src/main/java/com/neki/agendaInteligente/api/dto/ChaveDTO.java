package com.neki.agendaInteligente.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChaveDTO {
	
	private Long id;
	private String nome;
	private String slug;
	private String descricao;
	private Long chaveTipo;
	private boolean situacao;

}
