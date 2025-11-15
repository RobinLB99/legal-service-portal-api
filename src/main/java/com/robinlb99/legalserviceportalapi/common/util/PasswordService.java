package com.robinlb99.legalserviceportalapi.common.util;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    // Método para hashear nueva contraseña
    public String hashPassword(String rawPassword) {
        return passwordEncoder().encode(rawPassword);
    }

    // Método para comparar contraseña y hash guardado
    public boolean verifyPassword(String rawPassword, String savedHash) {
        return passwordEncoder().matches(rawPassword, savedHash);
    }
}
