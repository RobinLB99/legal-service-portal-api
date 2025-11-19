package com.robinlb99.legalserviceportalapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

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
