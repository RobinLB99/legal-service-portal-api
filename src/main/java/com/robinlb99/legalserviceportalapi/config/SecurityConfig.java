package com.robinlb99.legalserviceportalapi.config;

import com.robinlb99.legalserviceportalapi.common.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Clase de configuración de seguridad para la aplicación.
 * Define la configuración de seguridad web, incluyendo la autenticación
 * y la autorización de las solicitudes HTTP.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    /**
     * Define el proveedor de autenticación que se utilizará en la aplicación.
     * Utiliza un DaoAuthenticationProvider para autenticar a los usuarios contra
     * una fuente de datos a través de un UserDetailsService.
     *
     * @param userDetailsService El servicio que carga los detalles del usuario.
     * @return El proveedor de autenticación configurado.
     */
    @Bean
    public AuthenticationProvider authenticationProvider(
        CustomUserDetailsService userDetailsService
    ) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    /**
     * Define el codificador de contraseñas que se utilizará en la aplicación.
     * Utiliza BCryptPasswordEncoder para codificar y verificar las contraseñas.
     *
     * @return El codificador de contraseñas.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    /**
     * Define la cadena de filtros de seguridad que se aplicará a las solicitudes HTTP.
     * Configura las reglas de autorización para las rutas de la API,
     * deshabilita la protección CSRF y establece la autenticación básica.
     *
     * @param http El objeto HttpSecurity para configurar la seguridad.
     * @return La cadena de filtros de seguridad configurada.
     * @throws Exception Si ocurre un error al configurar la seguridad.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth ->
                auth
                    .requestMatchers("/api/registrarse/**").permitAll()
                    .requestMatchers(
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                    ).permitAll()

                    .requestMatchers("/api/admin/").permitAll()

                    .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults())
            .csrf(CsrfConfigurer<HttpSecurity>::disable);

        return http.build();
    }
}
