package com.neki.agendaInteligente.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name="chave_tipo", schema="agenda_inteligente")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChaveTipo {
	
	@Id
	@Column(name="chtp_cd_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long chtpCdId;
	
	@Column(name="chtp_tx_nome")
	private String chtpTxNome;

}
