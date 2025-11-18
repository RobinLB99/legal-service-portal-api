package com.robinlb99.legalserviceportalapi.common.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    
    private final PasswordEncoder passwordEncoder;

	public PasswordService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
    // Método para hashear nueva contraseña
    public String hashPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    // Método para comparar contraseña y hash guardado
    public boolean verifyPassword(String rawPassword, String savedHash) {
        return passwordEncoder.matches(rawPassword, savedHash);
    }
}
