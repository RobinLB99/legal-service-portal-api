package com.robinlb99.legalserviceportalapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de OpenAPI para la documentación de la API.
 */
@Configuration
public class OpenApiConfig {

    /**
     * Configura y personaliza la instancia de OpenAPI.
     *
     * @return una instancia de {@link OpenAPI} con la información de la API.
     */
    @Bean
    public OpenAPI CustomOpenAPI() {
        return new OpenAPI().info(
            new Info()
                .title("Legal Service Portal API")
                .description("Legal Service Portal API")
                .version("1.0.0")
                .termsOfService(
                    "https://github.com/robinlb99/legal-service-portal-api"
                )
                .license(new License().name("Apache 2.0"))
        );
    }
}
