package com.neki.agendaInteligente.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name="chave", schema="agenda_inteligente")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chave {

	@Id
	@Column(name="chav_cd_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long chavCdId;
	
	@Column(name="chav_tx_nome")
	private String chavTxNome;
	
	@Column(name="chav_tx_slug")
	private String chavTxSlug;
	
	@Column(name="chav_tx_descricao")
	private String chavTxDescricao;
	
	@JoinColumn(name="chtp_cd_id")
	@ManyToOne
	private ChaveTipo chaveTipo;
	
	@Column(name="chav_bl_ativo")
	private boolean chavBlAtivo;
	
}
