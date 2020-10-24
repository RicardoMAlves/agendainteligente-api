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
public class EmpresaDTO {

	private Long id;
	private String razaoSocial;
	private String fantasia;
	private String token;
	private Long tipoEmpresa;
	private boolean situacao;

}
