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
@Table( name="usuario", schema="tann_marcacao_inteligente")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	@Id
	@Column(name="usu_cd_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long usuCdId;
	
	@Column(name="usu_tx_nome")
	private String usuTxNome;
	
	@Column(name="usu_tx_email")
	private String usuTxEmail;
	
	@Column(name="usu_tx_senha")
	private String usuTxSenha;

}
