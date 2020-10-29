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
public class DentistaDTO {
	
	private Long id;
	private Long idpessoa;
	private String nome;
	private boolean ativo;
	private String tipoExecutor;

}
