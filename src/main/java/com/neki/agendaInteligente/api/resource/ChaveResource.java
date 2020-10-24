package com.neki.agendaInteligente.api.resource;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neki.agendaInteligente.api.dto.ChaveDTO;
import com.neki.agendaInteligente.exception.RegraNegocioException;
import com.neki.agendaInteligente.model.entity.Chave;
import com.neki.agendaInteligente.model.entity.ChaveTipo;
import com.neki.agendaInteligente.service.ChaveService;
import com.neki.agendaInteligente.service.ChaveTipoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/chaves")
@RequiredArgsConstructor
public class ChaveResource {
	
	private final ChaveService service;
	private final ChaveTipoService chaveTipoService;

	@GetMapping
	public ResponseEntity buscar(
			@RequestParam(value="descricao", required=false) String descricao) {
		
		Chave chaveFiltro = new Chave();
		chaveFiltro.setChavTxDescricao(descricao);
		chaveFiltro.setChavBlAtivo(true);
		
		List<Chave> chaves = service.buscar(chaveFiltro);
		return ResponseEntity.ok(chaves);
	}

	@PostMapping
	public ResponseEntity salvar(@RequestBody ChaveDTO dto) {
		try {
			Chave entidade = converter(dto);
			entidade = service.salvar(entidade);
			return new ResponseEntity(entidade, HttpStatus.CREATED);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody ChaveDTO dto) {
		return service.obterPorId(id).map( entity -> {
			try {
				Chave chave = converter(dto);
				chave.setChavCdId(entity.getChavCdId());
				service.atualizar(chave);
				return ResponseEntity.ok(chave);
			} catch (RegraNegocioException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}).orElseGet( () -> new ResponseEntity("Chave não encontrada.", HttpStatus.BAD_REQUEST));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deletar(@PathVariable("id") Long id) {
		return service.obterPorId(id).map( entity -> {
			service.deletar(entity);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet( () -> new ResponseEntity("Chave não encontrada.", HttpStatus.BAD_REQUEST));
	}
	
	private Chave converter(ChaveDTO dto) {
		
		Chave chave = new Chave();
		
		chave.setChavCdId(dto.getId());
		chave.setChavTxNome(dto.getNome());
		chave.setChavTxSlug(dto.getSlug());
		chave.setChavTxDescricao(dto.getDescricao());
		chave.setChavBlAtivo(true);
		
		ChaveTipo  chaveTipo = chaveTipoService
			.obterPorId(dto.getChaveTipo())
			.orElseThrow( () -> new RegraNegocioException("Tipo de Campo informado não existe.") );
		
		chave.setChaveTipo(chaveTipo);
		
		return chave;
	}
}
