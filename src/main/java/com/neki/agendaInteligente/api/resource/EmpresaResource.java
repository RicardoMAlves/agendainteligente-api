package com.neki.agendaInteligente.api.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neki.agendaInteligente.api.dto.EmpresaDTO;
import com.neki.agendaInteligente.exception.RegraNegocioException;
import com.neki.agendaInteligente.model.entity.Empresa;
import com.neki.agendaInteligente.service.EmpresaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
public class EmpresaResource {
	
	private final EmpresaService service;
	
	@GetMapping
	public ResponseEntity buscar() {
		List<Empresa> empresas = service.buscar();
		return ResponseEntity.ok(empresas);
	}
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody EmpresaDTO dto) {
		try {
			Empresa entidade = converter(dto);
			entidade = service.salvar(entidade);
			return new ResponseEntity(entidade, HttpStatus.CREATED);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody EmpresaDTO dto) {
		return service.obterPorId(id).map( entity -> {
			try {
				Empresa empresa = converter(dto);
				empresa.setEmpCdId(entity.getEmpCdId());
				service.atualizar(empresa);
				return ResponseEntity.ok(empresa);
			} catch (RegraNegocioException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}).orElseGet( () -> new ResponseEntity("Empresa não encontrada.", HttpStatus.BAD_REQUEST));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deletar(@PathVariable("id") Long id) {
		return service.obterPorId(id).map( entity -> {
			service.deletar(entity);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet( () -> new ResponseEntity("Empresa não encontrada.", HttpStatus.BAD_REQUEST));
	}

	private Empresa converter(EmpresaDTO dto) {
		
		Empresa empresa = new Empresa();
		
		empresa.setEmpCdId(dto.getId());
		empresa.setEmpTxRazaoSocial(dto.getRazaoSocial());
		empresa.setEmpTxNomeFantasia(dto.getFantasia());
		empresa.setEmpTxToken(dto.getToken());
		empresa.setEmpCdTipoEmpresa(dto.getTipoEmpresa());
		empresa.setEmpBlSituacao(true);
		
		return empresa;
	}
}
