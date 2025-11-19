package com.robinlb99.legalserviceportalapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Clase principal de la aplicación Spring Boot para Legal Service Portal API.
 * Esta clase arranca la aplicación y configura todos los componentes de Spring.
 */
@SpringBootApplication
public class LegalServicePortalApiApplication {

	/**
	 * Método principal que sirve como punto de entrada de la aplicación.
	 * Utiliza SpringApplication.run para iniciar la aplicación Spring Boot.
	 * @param args Argumentos de línea de comandos pasados a la aplicación.
	 */
	public static void main(String[] args) {
		SpringApplication.run(LegalServicePortalApiApplication.class, args);
	}

}

