package com.neki.agendaInteligente.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.neki.agendaInteligente.model.entity.Dentista;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonDentista {
	
	private Long pagina;
	private Long totalPaginas;
	private List<Dentista> lista;

}
