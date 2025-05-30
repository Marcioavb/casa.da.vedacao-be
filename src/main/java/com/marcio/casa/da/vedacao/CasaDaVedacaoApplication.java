package com.marcio.casa.da.vedacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class CasaDaVedacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasaDaVedacaoApplication.class, args);
	}
}
