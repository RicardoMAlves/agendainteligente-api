package com.neki.agendaInteligente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AgendaInteligenteApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(AgendaInteligenteApplication.class, args);
	}

}
