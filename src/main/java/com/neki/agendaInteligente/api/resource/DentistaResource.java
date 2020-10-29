package com.neki.agendaInteligente.api.resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.neki.agendaInteligente.model.entity.Dentista;
import com.neki.agendaInteligente.model.json.JsonDentista;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/executor-agenda/lista")
@RequiredArgsConstructor
public class DentistaResource {
	
	/*@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
	
	@Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
        	JsonDentista jsonDentista = restTemplate.getForObject(
                    "https://api.clinicanasnuvens.com.br/executor-agenda/lista", JsonDentista.class);
        };
    }
	
	@GetMapping
	public ResponseEntity buscar(RestTemplate restTemplate) {
		
		return ResponseEntity.ok();
		
	}*/

}
