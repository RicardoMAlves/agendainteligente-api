package com.neki.agendaInteligente.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name="empresas", schema="tann_marcacao_inteligente")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

	@Id
	@Column(name="emp_cd_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long empCdId;
	
	@Column(name="emp_tx_razao_social")
	private String empTxRazaoSocial;
	
	@Column(name="emp_tx_nome_fantasia")
	private String empTxNomeFantasia;
	
	@Column(name="emp_tx_token")
	private String empTxToken;
	
	@Column(name="emp_cd_tipo_empresa")
	private Long empCdTipoEmpresa;
		
	@Column(name="emp_bl_situacao")
	private boolean empBlSituacao;

	@Column(name="emp_dt_data_cadastro")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate empDtDataCadastro;

}
