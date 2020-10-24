package com.neki.agendaInteligente.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.agendaInteligente.model.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
